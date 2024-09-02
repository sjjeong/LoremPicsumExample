package com.dino.feature.photo_detail.compose

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dino.feature.photo_detail.PhotoDetailUiState
import com.dino.feature.photo_detail.PhotoDetailViewModel

@Composable
fun PhotoDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: PhotoDetailViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    PhotoDetailScreen(
        modifier = modifier,
        uiState = uiState,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PhotoDetailScreen(
    uiState: PhotoDetailUiState,
    modifier: Modifier = Modifier,
) {
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { onBackPressedDispatcher?.onBackPressed() }) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "뒤로가기"
                        )
                    }
                },
                title = {
                    if (uiState is PhotoDetailUiState.Found) {
                        Text(text = uiState.photoDetail.author)
                    }
                })
        }
    ) { paddingValue ->
        when (uiState) {
            PhotoDetailUiState.Loading -> {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(paddingValue)
                        .wrapContentWidth(Alignment.CenterHorizontally),
                    text = "데이터 불러오는 중..."
                )

            }

            is PhotoDetailUiState.Found -> {
                PhotoDetailFoundScreen(
                    modifier = Modifier.padding(paddingValue),
                    photoDetail = uiState.photoDetail
                )
            }

            PhotoDetailUiState.NotFound -> {
                PhotoDetailNotFoundScreen(
                    modifier = Modifier.padding(paddingValue),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PhotoDetailScreenPreviewLoading() {
    PhotoDetailScreen(uiState = PhotoDetailUiState.Loading)
}

@Preview(showBackground = true)
@Composable
private fun PhotoDetailScreenPreviewNotFound() {
    PhotoDetailScreen(uiState = PhotoDetailUiState.NotFound)
}
