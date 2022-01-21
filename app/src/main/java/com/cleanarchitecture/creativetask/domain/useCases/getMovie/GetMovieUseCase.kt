package com.cleanarchitecture.creativetask.domain.useCases.getMovie

import com.cleanarchitecture.creativetask.common.utility.constant.Resource
import com.cleanarchitecture.creativetask.data.remote.modeldto.MovieDetailResponseDto
import com.cleanarchitecture.creativetask.data.repository.MovieRepositoryImp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject


class GetMovieUseCase @Inject constructor(
    private val repository: MovieRepositoryImp

) {
    operator fun invoke(movieId: Int): Flow<Resource<MovieDetailResponseDto>> = flow {
        try {
            emit(Resource.Loading<MovieDetailResponseDto>())
            val movie = repository.getMovieById(movieId)
            emit(Resource.Success<MovieDetailResponseDto>(movie))
        } catch (e: HttpException) {
            emit(Resource.Error<MovieDetailResponseDto>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<MovieDetailResponseDto>("Couldn't reach server. Check your internet connection."))
        }
    }

}