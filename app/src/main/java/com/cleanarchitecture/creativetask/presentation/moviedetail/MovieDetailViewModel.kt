package com.cleanarchitecture.creativetask.presentation.moviedetail

import com.cleanarchitecture.creativetask.domain.useCases.getMovie.GetMovieUseCase
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel


class MovieDetailViewModel @Inject constructor(

    private val getMovieUseCase: GetMovieUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(MovieDetailState())
    val state: State<MovieDetailState> = _state

}




