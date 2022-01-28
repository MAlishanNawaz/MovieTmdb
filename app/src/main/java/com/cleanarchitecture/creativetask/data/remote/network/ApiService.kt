package com.cleanarchitecture.creativetask.data.remote.network

import androidx.paging.PagingSource
import com.cleanarchitecture.creativetask.data.remote.modeldto.Movie
import com.cleanarchitecture.creativetask.data.remote.modeldto.MovieDetailResponseDto
import com.cleanarchitecture.creativetask.data.remote.modeldto.PopularMoviesDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


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


    //https://api.themoviedb.org/3/search/movie?api_key=555dd34b51d2f5b7f9fdb39e04986933&
    // language=en-US&query=spiderman


    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(@Path("movie_id") movieId: Int): MovieDetailResponseDto

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int): PopularMoviesDto

//    @GET("search/movie")
//    suspend fun getSearchMovies(@Query("query") search: String): PopularMoviesDto

    @GET("search/movie")
    suspend fun getSearchMovies(@Query("query") search: String,@Query("query") page:Int): PopularMoviesDto

}