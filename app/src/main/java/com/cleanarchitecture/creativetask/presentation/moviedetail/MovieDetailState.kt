package com.cleanarchitecture.creativetask.presentation.moviedetail
import com.cleanarchitecture.creativetask.data.remote.modeldto.MovieDetailResponseDto
import com.cleanarchitecture.creativetask.domain.model.MovieDetail


data class MovieDetailState(

    val isLoading: Boolean = false,
    val movie: MovieDetailResponseDto? = null,
    val error: String = ""
)

