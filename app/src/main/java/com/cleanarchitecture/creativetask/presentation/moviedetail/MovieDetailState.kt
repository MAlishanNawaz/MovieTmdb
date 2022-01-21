package com.cleanarchitecture.creativetask.presentation.moviedetail

import com.cleanarchitecture.creativetask.domain.model.MovieDetail


data class MovieDetailState(

    val isLoading: Boolean = false,
    val movie: MovieDetail? = null,
    val error: String = ""
)

