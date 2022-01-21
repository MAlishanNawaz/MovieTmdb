package com.cleanarchitecture.creativetask.data.remote.modeldto


import com.cleanarchitecture.creativetask.domain.model.PopularMovie
import com.google.gson.annotations.SerializedName

data class PopularMoviesDto(
    val page: Int,
    @SerializedName("results")
    val movies: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)

fun PopularMoviesDto.toPopularMovies(): PopularMovie {

    return PopularMovie(
        page=page,
        movies=movies,
     totalPages=totalPages,
    totalResults=totalResults

    )
}