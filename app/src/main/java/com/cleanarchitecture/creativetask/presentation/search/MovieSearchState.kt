package com.cleanarchitecture.creativetask.presentation.search
import com.cleanarchitecture.creativetask.data.remote.modeldto.Movie
import com.cleanarchitecture.creativetask.data.remote.modeldto.MovieDetailResponseDto
import com.cleanarchitecture.creativetask.domain.model.MovieDetail


data class MovieSearchState(

    val isLoading: Boolean = false,
    val movie: Movie? =null,
    val error: String = ""
)

