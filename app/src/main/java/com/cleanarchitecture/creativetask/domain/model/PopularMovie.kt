package com.cleanarchitecture.creativetask.domain.model

import com.cleanarchitecture.creativetask.data.remote.modeldto.Movie

data class PopularMovie(

    val page: Int,
    val movies: List<Movie>,
    val totalPages: Int,
    val totalResults: Int

    )
