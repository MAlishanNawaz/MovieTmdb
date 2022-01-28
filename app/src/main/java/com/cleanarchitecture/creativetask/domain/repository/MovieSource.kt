package com.cleanarchitecture.creativetask.domain.repository

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.cleanarchitecture.creativetask.data.remote.modeldto.Movie
import java.io.IOException
import javax.inject.Inject
import kotlin.math.log

class MovieSource @Inject constructor(private val movieRepository: MovieRepository): PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        var nextPage = params.key ?: 1
        var movieResponse = listOf<Movie>()

        try {
            val nextPage = params.key ?: 1
            movieResponse = movieRepository.getPopularMovies(nextPage).movies
            Log.d("Data",""+movieResponse)

        } catch (retryableError: IOException) {
            return LoadResult.Error(retryableError)
        }
        return LoadResult.Page(
            data = movieResponse,
            prevKey = if (nextPage == 1) null else nextPage-1,
            nextKey = nextPage.plus(1)
        )

    }
}