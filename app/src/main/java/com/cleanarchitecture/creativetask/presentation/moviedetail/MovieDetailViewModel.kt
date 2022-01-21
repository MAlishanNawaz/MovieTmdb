package com.cleanarchitecture.creativetask.presentation.moviedetail

import com.cleanarchitecture.creativetask.domain.useCases.getMovie.GetMovieUseCase
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.cleanarchitecture.creativetask.common.utility.constant.Constant.PARAM_Movie_ID


class MovieDetailViewModel @Inject constructor(

    private val getMovieUseCase: GetMovieUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(MovieDetailState())
    val state: State<MovieDetailState> = _state

    init {
//        savedStateHandle.get<Int>(PARAM_Movie_ID)?.let {
//                movie_id ->
         //   getMovie(movie_id)
        }
    }

    private fun getMovie(movieId: Int) {
//        getMovieUseCase(movieId).onEach { result ->
//            when (result) {
//                is Resource.Success -> {
//                    _state.value = MovieDetailState(movie = result.data as MovieDto?)
//                }
//                is Resource.Error -> {
//                    _state.value = MovieDetailState(
//                        error = result.message ?: "An unexpected error occured"
//                    )
//                }
//                is Resource.Loading -> {
//                    _state.value = MovieDetailState(isLoading = true)
//                }
//            }
//        }.launchIn(viewModelScope)
    }
//}




