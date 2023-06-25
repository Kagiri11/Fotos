package com.cmaina.presentation.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.cmaina.domain.models.photos.DomainPhotoListItem
import com.cmaina.presentation.components.photoscards.PhotoCardItem
import com.cmaina.presentation.components.photostext.FotosTitleText
import com.cmaina.presentation.screens.items
import com.cmaina.presentation.screens.lazyItems
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = getViewModel(),
    navController: NavController
) {
    val scrollState = rememberLazyGridState()
    val coroutineScope = rememberCoroutineScope()
    var myPictures = viewModel.pics.observeAsState().value?.collectAsLazyPagingItems()

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (title, searchBar, fotosGrid) = createRefs()

        FotosTitleText(
            text = "Explore",
            textColor = MaterialTheme.colors.onPrimary,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top, margin = 20.dp)
                start.linkTo(parent.start, margin = 15.dp)
            }
        )

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            contentPadding = PaddingValues(1.dp),
            modifier = Modifier
                .constrainAs(fotosGrid) {
                    top.linkTo(title.bottom, margin = 10.dp)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                }
                .fillMaxWidth(),
        ) {
            lazyItems(myPictures!!) { pic ->
                PhotoCardItem(
                    blurHash = pic?.blurHash ?: "",
                    imageUrl = pic?.domainUrls?.small,
                    navController = navController,
                    photoID = pic?.id ?: ""
                )
            }
        }
    }
}
