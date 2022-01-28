package com.cleanarchitecture.creativetask.domain.repository

import com.cleanarchitecture.creativetask.data.remote.modeldto.MovieDetailResponseDto
import com.cleanarchitecture.creativetask.data.remote.modeldto.PopularMoviesDto

interface MovieRepository {


    suspend fun getMovieById(movie_id:Int): MovieDetailResponseDto
    suspend fun getPopularMovies(pageNumber: Int): PopularMoviesDto
    suspend fun getSearchMovies(query:String): PopularMoviesDto

}
