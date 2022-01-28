package com.cleanarchitecture.creativetask.data.repository

import androidx.paging.PagingSource
import com.cleanarchitecture.creativetask.data.remote.modeldto.MovieDetailResponseDto
import com.cleanarchitecture.creativetask.data.remote.modeldto.PopularMoviesDto
import javax.inject.Inject
import com.cleanarchitecture.creativetask.data.remote.network.ApiService
import com.cleanarchitecture.creativetask.domain.repository.MovieRepository


class MovieRepositoryImp @Inject  constructor(private val api : ApiService) : MovieRepository {


    override suspend fun getMovieById(movie_id: Int): MovieDetailResponseDto {

       return api.getMovieDetail(movie_id)
    }


    override suspend fun getPopularMovies(pageNumber: Int): PopularMoviesDto {

        return api.getPopularMovies(pageNumber)

    }

    override suspend fun getSearchMovies(query: String): PopularMoviesDto {
        TODO("Not yet implemented")
    }


}