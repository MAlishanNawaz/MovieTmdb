package com.cleanarchitecture.creativetask.domain.useCases.getPopularmovies

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.cleanarchitecture.creativetask.common.utility.constant.Resource
import com.cleanarchitecture.creativetask.data.remote.modeldto.Movie
import com.cleanarchitecture.creativetask.data.remote.modeldto.toPopularMovies
import com.cleanarchitecture.creativetask.data.repository.MovieRepositoryImp
import com.cleanarchitecture.creativetask.domain.model.PopularMovie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val repository: MovieRepositoryImp) {

   // operator fun invoke(page:Int,perPage:Int): Flow<Resource<PopularMovie>> = flow {


//        try {
//            emit(Resource.Loading<PopularMovie>())
//            val results = repository.getPopularMovies(page, perPage).toPopularMovies()
//            Log.d("Data",""+results.movies.size)
//            emit(Resource.Success<PopularMovie>(results))
//        } catch (e: HttpException) {
//            emit(Resource.Error<PopularMovie>(e.localizedMessage ?: "An unexpected error occured"))
//        } catch (e: IOException) {
//            emit(Resource.Error<PopularMovie>("Couldn't reach server. Check your internet connection."))
//        }
  //  }
//private val pager: Pager<Int, Movie> =
//    Pager(config = PagingConfig(pageSize = 20), pagingSourceFactory = ::initPagingSource)
//    val movies: Flow<PagingData<Movie>> = pager.flow




}



