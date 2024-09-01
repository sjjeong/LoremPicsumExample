package com.dino.lorempicsumexample.feature.photo_list.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.dino.lorempicsumexample.feature.photo_list.PhotoListViewModel
import com.dino.lorempicsumexample.feature.photo_list.model.PhotoModel

@Composable
fun PhotoListScreen(
    modifier: Modifier = Modifier,
    viewModel: PhotoListViewModel = viewModel(),
) {
    val items = viewModel.items.collectAsLazyPagingItems()
    PhotoListScreen(
        modifier = modifier,
        items = items,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PhotoListScreen(
    items: LazyPagingItems<PhotoModel>,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = {
                Text(text = "LoremPicsumExample")
            })
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = modifier.padding(paddingValues = paddingValues),
            contentPadding = PaddingValues(4.dp),
        ) {
            if (items.loadState.refresh == LoadState.Loading) {
                item {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally),
                        text = "데이터 불러오는 중..."
                    )
                }
            }
            items(
                count = items.itemCount,
                key = { items[it]?.id ?: it }
            ) { index ->
                val item = items[index]
                if (item != null) {
                    PhotoListItem(item = item)
                }
            }

            if (items.loadState.append == LoadState.Loading) {
                item {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally)
                    )
                }
            }
        }

    }

}
