package com.cleanarchitecture.creativetask.presentation.movielist

import com.cleanarchitecture.creativetask.domain.model.PopularMovie

data class MovieListState(
    val isLoading: Boolean = false,
    val movies: PopularMovie? = null,
    val error: String = ""
)
