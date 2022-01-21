package com.cleanarchitecture.creativetask.presentation.movielist


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cleanarchitecture.creativetask.data.remote.modeldto.Movie
import com.cleanarchitecture.creativetask.presentation.movielist.components.MovieListItem
import java.util.*
import kotlin.collections.ArrayList

@Composable
fun MovieListScreen(

    viewModel: MovieListViewModel = hiltViewModel(),
    stateTextField: MutableState<TextFieldValue>,
    navController:NavController
) {

    val _state=viewModel.state.value.movies
    var movies :List<Movie>
    LazyColumn(modifier = Modifier.fillMaxWidth()
    ) {
         movies = _state?.movies ?: listOf()

        val searchedText = stateTextField.value.text
        var filteredMovies: List<Movie> = if(searchedText.isEmpty()) {
            for (movie in movies) {
                val title = movie.title
                val id = movie.id
                val posterPath = movie.posterPath
                val releaseDate = movie.releaseDate
            }
            movies
        } else {
            val resultList = ArrayList<Movie>()
            for (movie in movies) {
                if (movie.title.lowercase(Locale.getDefault())
                        .contains(searchedText.lowercase(Locale.getDefault()))
                ) {
                    resultList.add(movie)
                }
            }
            resultList
        }
        items(filteredMovies) { _filteredMovie ->
            MovieListItem(
                movie = _filteredMovie,
                onItemClick = { _filteredMovie.title
                    navController.navigate("details/${_filteredMovie.title}") {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo("main") {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }

}













