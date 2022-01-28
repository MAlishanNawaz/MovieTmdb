package com.cleanarchitecture.creativetask.presentation.moviedetail

import android.util.Log
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleanarchitecture.creativetask.common.utility.constant.Constant.key_Movie
import com.cleanarchitecture.creativetask.common.utility.constant.Resource
import com.cleanarchitecture.creativetask.domain.model.MovieDetail
import com.cleanarchitecture.creativetask.domain.useCases.getMovie.GetMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase,
    savedStateHandle: SavedStateHandle

) : ViewModel() {
    private val _state = mutableStateOf(MovieDetailState())
    val state: State<MovieDetailState> = _state

    init {
        savedStateHandle.get<String>(key_Movie)?.let { id ->
            getMovieById(id.toInt())
        }

    }

    private fun getMovieById(Id:Int){
        getMovieUseCase(Id).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = MovieDetailState(movie = result.data)
                }
                is Resource.Error -> {
                    _state.value = MovieDetailState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = MovieDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
