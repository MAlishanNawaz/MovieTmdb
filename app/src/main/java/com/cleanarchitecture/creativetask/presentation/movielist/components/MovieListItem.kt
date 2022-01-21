package com.cleanarchitecture.creativetask.presentation.movielist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.cleanarchitecture.creativetask.data.remote.modeldto.Movie


@Composable
fun MovieListItem(movie:Movie , onItemClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = { onItemClick(movie.title) })
//            .background()
            .height(57.dp)
            .fillMaxWidth()
            .padding(PaddingValues(8.dp, 16.dp))
    ) {
        Text(text = movie.title, fontSize = 18.sp, color = Color.White)


    }
}



