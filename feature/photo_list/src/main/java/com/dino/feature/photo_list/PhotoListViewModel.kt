package com.dino.feature.photo_list

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.dino.core.data.repository.PicsumRepository
import com.dino.core.ui.base.BaseViewModel
import com.dino.feature.photo_list.model.PhotoModel
import com.dino.feature.photo_list.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    picsumRepository: PicsumRepository,
) : BaseViewModel() {
    val items: Flow<PagingData<PhotoModel>> = picsumRepository.getPhotosPaging()
        .cachedIn(viewModelScope)
        .map { pagingData ->
            pagingData.map {
                it.toUiModel()
            }
        }
}
