package com.cleanarchitecture.creativetask.data.remote.network

import com.cleanarchitecture.creativetask.data.remote.modeldto.MovieDetailResponseDto
import com.cleanarchitecture.creativetask.data.remote.modeldto.PopularMoviesDto
import retrofit2.http.GET
import retrofit2.http.Path


// https://api.themoviedb.org/3/
// https://api.themoviedb.org/3/movie/popular?api_key=555dd34b51d2f5b7f9fdb39e04986933&page=1
// https://api.themoviedb.org/3/movie/299534?api_key=555dd34b51d2f5b7f9fdb39e04986933

/******
 Api End Point
***********/

interface ApiService {

    /******
    https://api.themoviedb.org/3/movie/popular?api_key=555dd34b51d2f5b7f9fdb39e04986933
     ***********/

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(@Path("movie_id") movieId: Int): MovieDetailResponseDto

    @GET("movie/popular")
    suspend fun getLatestMovies(): PopularMoviesDto


}