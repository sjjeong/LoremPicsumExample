package com.dino.lorempicsumexample.feature.photo_list

import androidx.paging.PagingData
import androidx.paging.map
import com.dino.lorempicsumexample.base.BaseViewModel
import com.dino.lorempicsumexample.data.repository.PicsumRepository
import com.dino.lorempicsumexample.feature.photo_list.model.PhotoModel
import com.dino.lorempicsumexample.feature.photo_list.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    private val picsumRepository: PicsumRepository,
) : BaseViewModel() {
    val items: Flow<PagingData<PhotoModel>> = picsumRepository.getPhotosPaging()
        .map { pagingData ->
            pagingData.map {
                it.toUiModel()
            }
        }
}
