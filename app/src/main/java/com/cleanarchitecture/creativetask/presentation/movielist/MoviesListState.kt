package com.cleanarchitecture.creativetask.presentation.movielist

import com.cleanarchitecture.creativetask.data.remote.modeldto.Movie

data class MoviesListState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = ""
)
