package com.cleanarchitecture.creativetask.presentation.movielist

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.cleanarchitecture.creativetask.data.remote.modeldto.Movie
import com.cleanarchitecture.creativetask.domain.repository.MovieSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val movieSource: MovieSource
    ) : ViewModel() {

     fun getAllGames(): Flow<PagingData<Movie>> {
        return Pager(PagingConfig(20)) { movieSource }.flow

    }

//    private val _state = mutableStateOf(MoviesListState())
//    val state: State<MoviesListState> = _state
//     val _movies=MutableLiveData<List<Movie>>()
//
//     var endReached = mutableStateOf(false)
//     var curPage = 1
//     var perPageitems = 20
//
//
//    init{
//           getMovies(curPage,perPageitems)
//
//    }
//
//    fun getMovies(page: Int ,perPage: Int) {
//
////           val movie=_movies.value?.toMutableList() ?: mutableListOf()//
//
//                getMoviesUseCase(page,perPage).onEach { result ->
//                    when (result) {
//                        is Resource.Success -> {
//
//                            endReached.value= curPage*perPageitems >= result.data?.totalPages!!
//                             _state.value=MoviesListState(movies = result.data.movies)
//                             curPage++
//
////                            prevKey = if (curPage == 1) 0 else curPage - 1
////                            nextKey = curPage++
//                        }
//                        is Resource.Error -> {
//                            _state.value = MoviesListState(
//                                error = result.message ?: "An unexpected error occured"
//                            )
//                        }
//                        is Resource.Loading -> {
//                            _state.value = MoviesListState(isLoading = true)
//
//
//                        }
//                    }
//
//                }.launchIn(viewModelScope)
//            }
//
//    fun getSearchResults(query:String) {
//
//        getSearchMovies(query).onEach { result ->
//            when (result) {
//                is Resource.Success -> {
////                    _state.value = MoviesListState(movies = ((result.data ?: null)))
//
//                }
//                is Resource.Error -> {
//                    _state.value = MoviesListState(
//                        error = result.message ?: "Sorry Data Not Found"
//                    )
//                }
//                is Resource.Loading -> {
//                    _state.value = MoviesListState(isLoading = true)
//                }
//            }
//
//        }.launchIn(viewModelScope)
//    }

}
