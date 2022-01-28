package com.cleanarchitecture.creativetask.presentation.search

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import com.cleanarchitecture.creativetask.domain.useCases.getSearchMovies.GetSearchMovies
import com.cleanarchitecture.creativetask.presentation.movielist.MoviesListState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getSearchMovies: GetSearchMovies
) : ViewModel() {

    private val _state = mutableStateOf(TextFieldValue(""))

    val state: MutableState<TextFieldValue> = _state


    // val filterTextAll= ""

    init {
     //   getMovies()
    }

//    private fun getMovies() {
//
//
//            }.launchIn(viewModelScope)
//        }
}
