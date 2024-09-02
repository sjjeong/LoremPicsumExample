package com.dino.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dino.core.data.datasource.local.PicsumLocalDataSource
import com.dino.core.data.datasource.remote.PicsumRemoteDataSource
import com.dino.core.data.model.PicsumPhotoDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PicsumRepositoryImpl @Inject constructor(
    private val remoteDataSource: PicsumRemoteDataSource,
    private val localDataSource: PicsumLocalDataSource,
) : PicsumRepository {

    override fun getPhotosPaging(): Flow<PagingData<PicsumPhotoDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
            ),
            pagingSourceFactory = {
                object : PagingSource<Int, PicsumPhotoDto>() {

                    override fun getRefreshKey(state: PagingState<Int, PicsumPhotoDto>): Int? {
                        return state.anchorPosition?.let { anchorPosition ->
                            val anchorPage = state.closestPageToPosition(anchorPosition)
                            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
                        }
                    }

                    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PicsumPhotoDto> {
                        return kotlin.runCatching {
                            val currentPage = params.key ?: 0
                            val response = remoteDataSource.getPhotos(
                                page = currentPage,
                                limit = params.loadSize,
                            )

                            val data = response.first
                            localDataSource.savePhotos(data)
                            LoadResult.Page(
                                data = data,
                                prevKey = null,
                                nextKey = if (response.second) {
                                    if (currentPage == 0) {
                                        // PagingConfig 의 pageSize*3 로직에 따라 최초 로딩 이후 로딩은 3으로 시작
                                        3
                                    } else {
                                        currentPage + 1
                                    }
                                } else null
                            )
                        }.getOrElse {
                            LoadResult.Error(it)
                        }
                    }
                }
            }
        ).flow
    }

    override suspend fun getPhoto(id: String): PicsumPhotoDto {
        val photo = localDataSource.getPhoto(id)
        return if (photo == null) {
            val newPhoto = remoteDataSource.getPhoto(id)
            localDataSource.savePhoto(newPhoto)
            newPhoto
        } else {
            photo
        }
    }
}
