package com.dino.feature.photo_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.dino.core.data.repository.PicsumRepository
import com.dino.core.ui.base.BaseViewModel
import com.dino.feature.photo_detail.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class PhotoDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val picsumRepository: PicsumRepository,
) : BaseViewModel() {

    private val id: StateFlow<String> = savedStateHandle.getStateFlow("id", "")

    val uiState: StateFlow<PhotoDetailUiState> = id.map {
        if (it.isBlank()) {
            PhotoDetailUiState.NotFound
        } else {
            PhotoDetailUiState.Found(picsumRepository.getPhoto(it).toUiModel())
        }
    }.catch {
        emit(PhotoDetailUiState.NotFound)
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        PhotoDetailUiState.Loading
    )

}
