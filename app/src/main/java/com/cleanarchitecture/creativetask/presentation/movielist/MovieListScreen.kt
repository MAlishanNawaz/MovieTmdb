package com.cleanarchitecture.creativetask.presentation.movielist


import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.cleanarchitecture.creativetask.presentation.movielist.components.MovieListItem
import com.cleanarchitecture.creativetask.route.Screen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieListScreen(
    viewModel: MovieListViewModel = hiltViewModel(),
    navController:NavController
    ) {
    val movie=viewModel.getAllGames()
    val lazyItems = movie.collectAsLazyPagingItems()
    val scrollState = rememberScrollState()

    LazyVerticalGrid(
        cells = GridCells.Fixed(2),

        content = {
            items(lazyItems.itemCount) { index ->
                lazyItems.getAsState(index)?.let {
                    it.value?.let { movie ->
                        MovieListItem(
                            movie,
                            onItemClick = {movie.id
                                Log.d("Id","Title"+ movie.id+movie.title )
                                navController.navigate(Screen.MovieDetailScreen.route + "/${movie.id}") {
                                    // Pop up to the start destination of the graph to
                                    // avoid building up a large stack of destinations
                                    // on the back stack as users select items

                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                    // Restore state when reselecting a previously selected item
                                    restoreState = true
//                                    popUpTo("main") {
//                                        saveState = true
//                                    }
//                                    // Avoid multiple copies of the same destination when
//                                    // reselecting the same item
//                                    launchSingleTop = true
//                                    // Restore state when reselecting a previously selected item
//                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
            lazyItems.apply {

                when {
                    loadState.refresh is
                            LoadState.Loading -> {
                        item { LoadingItem() }
                        item { LoadingItem() }
                    }
                    loadState.append is
                            LoadState.Loading -> {
                        item { LoadingItem() }
                        item { LoadingItem() }
                    }
                    loadState.refresh is
                            LoadState.Error -> {}
                    loadState.append is
                            LoadState.Error -> {}
                }
            }
        }
    )
}

@Composable
fun LoadingItem() {
    CircularProgressIndicator(
        modifier =
        Modifier
            .testTag("ProgressBarItem")
            .fillMaxWidth()
            .padding(16.dp)
            .wrapContentWidth(
                Alignment.CenterHorizontally
            )
    )
}




//
//    var endReached = viewModel.endReached
//    var curPage = viewModel.curPage
//    var perPageitems = viewModel.perPageitems
//    val state = viewModel.state.value

//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier.fillMaxSize()
//    ) {
//
//    LazyVerticalGrid(
//        cells = GridCells.Fixed(CELL_COUNT)
//    ) {
//        val searchedText = filterTextAll.value.text
//        var movies=state.movies
//
//        var filteredMovies: List<Movie> = if (searchedText.isEmpty()) {
//            movies
//        } else {
//            val resultList = ArrayList<Movie>()
//            for (movie in movies) {
//                if (movie.title.lowercase(Locale.getDefault())
//                        .contains(searchedText.lowercase(Locale.getDefault()))
//                ) {
//                    resultList.add(movie)
//                }
//            }
//            resultList
//        }
//
//
//
//            itemsIndexed(items=filteredMovies) { index ,_filteredMovie ->
//
//                if(index==movies.lastIndex && !state.isLoading){
//                    viewModel.getMovies(curPage, perPageitems)
//                }
//                MovieListItem(
//                    movie = _filteredMovie,
//                    onItemClick = {
//                     //   navController.navigate(Screen.MovieDetailScreen.route + "/${_filteredMovie.id}")
//                       navController.navigate("details/${_filteredMovie.id}") //{
//                            // Pop up to the start destination of the graph to
//                            // avoid building up a large stack of destinations
//                            // on the back stack as users select items
//                        {
//                            popUpTo("main") {
//                                saveState = true
//                            }
//                            // Avoid multiple copies of the same destination when
//                            // reselecting the same item
//                            launchSingleTop = true
//                            // Restore state when reselecting a previously selected item
//                            restoreState = true
//                        }
//                    }
//                )
//            }
//
//    }
//
//
//
//        if (state.error.isBlank()) {
//            Text(
//                text = state.error,
//                color = MaterialTheme.colors.error,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 20.dp)
//                    .align(Alignment.Center)
//            )
//
//        }
//        if (state.isLoading) {
//            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
//        }
//
//    }
//}




















