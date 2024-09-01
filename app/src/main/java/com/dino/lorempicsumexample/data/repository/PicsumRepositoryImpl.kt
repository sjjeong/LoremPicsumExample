package com.dino.lorempicsumexample.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dino.lorempicsumexample.data.datasource.remote.PicsumRemoteDataSource
import com.dino.lorempicsumexample.data.model.PicsumPhotoDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PicsumRepositoryImpl @Inject constructor(
    private val remoteDataSource: PicsumRemoteDataSource,
) : PicsumRepository {

    override fun getPhotosPaging(): Flow<PagingData<PicsumPhotoDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
            ),
            pagingSourceFactory = {
                object : PagingSource<Int, PicsumPhotoDto>() {
                    override fun getRefreshKey(state: PagingState<Int, PicsumPhotoDto>): Int? {
                        TODO("Not yet implemented")
                    }

                    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PicsumPhotoDto> {
                        return kotlin.runCatching {
                            val currentPage = params.key ?: 0
                            val response = remoteDataSource.getPhotos(
                                page = currentPage,
                                limit = params.loadSize,
                            )

                            LoadResult.Page(
                                data = response,
                                prevKey = if (currentPage == 0) null else currentPage - 1,
                                nextKey = if (response.isEmpty()) null else currentPage + 1
                            )
                        }.getOrElse {
                            LoadResult.Error(it)
                        }
                    }
                }
            }
        ).flow
    }
}
