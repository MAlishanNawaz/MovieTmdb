package com.cleanarchitecture.creativetask.presentation.movielist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.cleanarchitecture.creativetask.common.utility.constant.Constant.PosterUrl
import com.cleanarchitecture.creativetask.data.remote.modeldto.Movie
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MovieListItem(movie: Movie, onItemClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .clickable(onClick = { onItemClick(movie.id.toString()) })
            .fillMaxWidth()
            .padding(PaddingValues(8.dp, 8.dp))
    ) {

        CoilImage(

            imageModel = PosterUrl+movie.posterPath,
            modifier = Modifier.size(320.dp),
            contentScale = ContentScale.FillHeight,
            circularReveal = CircularReveal(duration = 250),
            // shows a shimmering effect when loading an image.
            shimmerParams = ShimmerParams(
                baseColor = MaterialTheme.colors.background,
                highlightColor = Color.Cyan,
                durationMillis = 350,
                dropOff = 0.65f,
                tilt = 20f
            ),

            // shows an error text message when request failed.
            failure = {
                Text(text = "image request failed.")
            })
            Box {
                MovieRate(
                    movie.voteAverage,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .zIndex(5f)
                        .offset(y = (-12).dp),
                )
            }
           Box {

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

@Composable
private fun MovieRate(rate: Double, modifier: Modifier) {
    val shape = RoundedCornerShape(percent = 80)
    Surface(
        shape = shape,
        elevation = 12.dp,
        modifier = modifier
    ) {
        Text(
            text = rate.toString(),
            style = MaterialTheme.typography.body1.copy(color = Color.White),
            modifier = Modifier
                .background(Brush.horizontalGradient(Color.rateColors(movieRate = rate)))
                .padding(horizontal = 10.dp)
        )
    }
}

@Composable
private fun MovieInfo(movie: Movie,modifier: Modifier) {
    Column(
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
                fontWeight = FontWeight.W200,
            ),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier.padding(horizontal = 2.dp)
        )
    }
}

@Composable
fun Color.Companion.rateColors(movieRate: Double): List<Color> = remember(movieRate) {
    when {
        movieRate <= 4.5 -> listOf(Color(0xffe32d20), Color(0xff9c180e))
        movieRate < 7 -> listOf(Color(0xffe36922), Color(0xff963d09))
        movieRate < 8.5 -> listOf(Color(0xff87bf32), Color(0xff578216))
        else -> listOf(Color(0xff34c937), Color(0xff0d750f))
    }
}


