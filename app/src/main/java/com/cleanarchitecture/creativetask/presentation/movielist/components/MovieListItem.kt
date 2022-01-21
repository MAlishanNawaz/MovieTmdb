package com.cleanarchitecture.creativetask.presentation.movielist.components

import android.graphics.fonts.FontFamily
import androidx.appcompat.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily.Companion.SansSerif
import androidx.compose.ui.text.font.FontFamily.Companion.Serif
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.ImagePainter
import com.cleanarchitecture.creativetask.common.utility.constant.Constant.POSTER_BASE_URL
import com.cleanarchitecture.creativetask.data.remote.modeldto.Movie

@Composable
fun MovieListItem(movie:Movie , onItemClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = { onItemClick(movie.title) })
            .background(colorResource(id = R.color.primary_dark_material_dark))
            .height(57.dp)
            .fillMaxWidth()
            .padding(PaddingValues(8.dp, 16.dp))
    ) {
        Text(text = movie.title, fontSize = 18.sp, color = Color.White)
        Text(text = movie.posterPath, fontSize = 18.sp, color = Color.White)
        Text(text = movie.releaseDate, fontSize = 18.sp, color = Color.White)

    }
}


@Composable
fun MovieContent(movie: Movie, onItemClick: (String) -> Unit) {
    Box(modifier= Modifier
        .clickable(onClick = { onItemClick(movie.title) })) {
        MovieRate(
            movie.voteAverage,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .zIndex(2f)
        )
        Card(
            modifier = Modifier
                .fillMaxSize()
                .offset(y = 12.dp),
            shape = RoundedCornerShape(size = 8.dp),
            elevation = 8.dp,
          //  onClick = { onMovieClicked(movie.id) }
        ) {
            Box {
                MoviePoster(movie.posterPath, movie.title)
                MovieInfo(
                    movie,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .background(Color(0x97000000))
                )
            }
        }
    }
}

@Composable
private fun BoxScope.MoviePoster(posterPath: String, movieName: String) {
    val tint = if (MaterialTheme.colors.isLight) Color.Gray else Color.DarkGray
    val painter = rememberImagePainter(data = posterPath)
    Image(
        painter = painter,
        contentDescription = stringResource(POSTER_BASE_URL, movieName),
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
    val modifier = Modifier
        .padding(8.dp)
        .fillMaxSize()
        .align(Alignment.Center)
    when (painter.state) {
        is ImagePainter.State.Loading -> {
            Image(
                painter = rememberVectorPainter(image = Icons.Default.ThumbUp),
                contentDescription = null,
                colorFilter = ColorFilter.tint(tint),
                modifier = modifier
            )
        }
        is ImagePainter.State.Error -> {
            Image(
                imageVector = Icons.Filled.ThumbUp,
                contentDescription = null,
                colorFilter = ColorFilter.tint(tint),
                modifier = modifier
            )
        }
        else -> {
        }
    }
}




@Composable
private fun MovieRate(rate: Double, modifier: Modifier) {
    val shape = RoundedCornerShape(percent = 50)
    Surface(
        shape = shape,
        elevation = 12.dp,
        modifier = modifier
    ) {
        Text(
            text = rate.toString(),
            style = MaterialTheme.typography.body1.copy(color = Color.White),
            modifier = Modifier
                .padding(horizontal = 10.dp)
        )
    }
}

@Composable
private fun MovieInfo(movie: Movie, modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier.padding(horizontal = 6.dp, vertical = 4.dp)
    ) {
        MovieName(name = movie.title)
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            MovieFeature(Icons.Default.DateRange, movie.releaseDate)
            MovieFeature(Icons.Default.ThumbUp, movie.voteCount.toString())
        }
    }
}

@Composable
private fun MovieName(name: String) = Text(
    text = name,
    style = MaterialTheme.typography.subtitle1.copy(
        color = Color.White,
        letterSpacing = 1.5.sp,
        fontWeight = FontWeight.W500,
    ),
    maxLines = 1,
    overflow = TextOverflow.Ellipsis
)

@Composable
private fun MovieFeature(icon: ImageVector, field: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(13.dp))
        Text(
            text = field,
            style = MaterialTheme.typography.subtitle2.copy(
                color = Color.White,
                letterSpacing = 1.5.sp,
                fontWeight = FontWeight.W400
            ),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier.padding(horizontal = 2.dp)
        )
    }
}






