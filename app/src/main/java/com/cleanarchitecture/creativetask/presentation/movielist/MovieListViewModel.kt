package com.cleanarchitecture.creativetask.presentation.movielist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleanarchitecture.creativetask.common.utility.constant.Resource
import com.cleanarchitecture.creativetask.domain.useCases.getPopularmovies.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(MovieListState())
    val state: State<MovieListState> = _state

    init {

        getMovies()
    }

    private fun getMovies() {
        getMoviesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value=MovieListState(movies = ((result.data?: null)))

                }
                is Resource.Error -> {
                    _state.value = MovieListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = MovieListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}