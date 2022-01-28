package com.cleanarchitecture.creativetask.presentation.moviedetail

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import com.cleanarchitecture.creativetask.common.utility.constant.Constant
import com.cleanarchitecture.creativetask.common.utility.constant.springAnimation
import com.cleanarchitecture.creativetask.data.remote.modeldto.Genre
import com.cleanarchitecture.creativetask.data.remote.modeldto.Movie
import com.cleanarchitecture.creativetask.data.remote.modeldto.MovieDetailResponseDto
import com.cleanarchitecture.creativetask.data.remote.modeldto.toMoviedetail
import com.cleanarchitecture.creativetask.domain.model.MovieDetail
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MovieDetailScreen(

    viewModel: MovieDetailViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Log.d("TAG",state.toString())

    if (state.movie !== null) {
     val movie=state.movie

        val scrollState = rememberScrollState()


        BoxWithConstraints {
            val maxheight = this@BoxWithConstraints.maxHeight
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)

                ) {
                    // TODO:
                    Box {
                        MovieHeaderBg(movie.backdropPath, maxheight)

                        Scaffold(
                            backgroundColor = Color.Transparent,   // Make the background transparent
                            modifier =Modifier.padding(20.dp,20.dp,20.dp,20.dp)
                        ) {
                            MovieHeader(
                                movie.posterPath, maxheight)
                        }


                    }
                    HeaderProperty("Title", movie.originalTitle)
                    ProfileProperty("OverView Title", movie.overview)
                    ProfileProperty("Release Data", movie.releaseDate)
                    ProfileProperty("Total Budget", movie.budget.toString())
                    ProfileProperty("Revenue", movie.revenue.toString())

                }
            }



        }
    }

    if (!state.error.isBlank()) {
        Box(modifier = Modifier.fillMaxSize()) {

        Text(
            text = "Error",
            color = MaterialTheme.colors.error,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .align(Alignment.Center)
        )
    }
   }

  if (state.isLoading) {
            Box(modifier = Modifier.fillMaxSize()) {

            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Composable
fun HeaderProperty(label: String, value: String) {
    Column(modifier = Modifier.padding(start = 16.dp,top = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider(modifier = Modifier.padding(bottom = 4.dp))
        Text(
            text = label,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.body1,
        )
        Text(
            text = value,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.h5,
            overflow = TextOverflow.Visible
        )
    }
}
@Composable
fun ProfileProperty(label: String, value: String) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider(modifier = Modifier.padding(bottom = 4.dp))
        Text(
            text = label,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.caption,
        )
        Text(
            text = value,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Visible
        )
    }
}


@Composable
private fun MovieHeader(
    posterUrl: String,
    containerHeight: Dp,

) {
    CoilImage(

        imageModel = Constant.PosterUrl + posterUrl,
        modifier = Modifier.heightIn(max = containerHeight/2),
        contentScale = ContentScale.FillHeight,
        circularReveal = CircularReveal(duration = 250),
        // shows a shimmering effect when loading an image.
        shimmerParams = ShimmerParams(
            baseColor = MaterialTheme.colors.background,
            highlightColor = Color.Cyan,
            durationMillis = 350,
            dropOff = 0.65f,
            tilt = 20f),
        // shows an error text message when request failed.
        failure = {
            Text(text = "image request failed.")
        })

}
@Composable
private fun MovieHeaderBg(
    posterUrl: String,
    containerHeight: Dp,
) {
    CoilImage(

        imageModel = Constant.PosterUrl + posterUrl,
        modifier = Modifier.heightIn(max = containerHeight/2),
        contentScale = ContentScale.FillHeight,
        circularReveal = CircularReveal(duration = 250),
        // shows a shimmering effect when loading an image.
        shimmerParams = ShimmerParams(
            baseColor = MaterialTheme.colors.background,
            highlightColor = Color.Cyan,
            durationMillis = 350,
            dropOff = 0.65f,
            tilt = 20f),
        // shows an error text message when request failed.
        failure = {
            Text(text = "image request failed.")
        })
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Poster(posterUrl: String, movieName: String, modifier: Modifier) {
    val isScaled = remember { mutableStateOf(false) }
    val scale =
        animateFloatAsState(targetValue = if (isScaled.value) 2.2f else 1f, animationSpec = springAnimation).value

    Card(
        elevation = 24.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = modifier.scale(scale),
        onClick = { isScaled.value = !isScaled.value }
    ) {
        CoilImage(

            imageModel = Constant.PosterUrl + posterUrl,
            modifier = Modifier.size(320.dp),
            contentScale = ContentScale.FillHeight,
            circularReveal = CircularReveal(duration = 250),
            // shows a shimmering effect when loading an image.
            shimmerParams = ShimmerParams(
                baseColor = MaterialTheme.colors.background,
                highlightColor = Color.Cyan,
                durationMillis = 350,
                dropOff = 0.65f,
                tilt = 20f),
                        // shows an error text message when request failed.
            failure = {
                    Text(text = "image request failed.")
                })

        Row(
            modifier
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
        ) {


        }

    }
}

@Composable
fun GenreChips(genres: List<Genre>, modifier: Modifier) {
    Row(
        modifier
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
    ) {
        genres.map(Genre::name).forEachIndexed { index, name ->
            Text(
                text = name.orEmpty(),
                style = MaterialTheme.typography.subtitle1.copy(letterSpacing = 2.sp),
                modifier = Modifier
                    .border(
                        1.25.dp,
                        Color.Cyan,
                        RoundedCornerShape(50)
                    )
                    .padding(horizontal = 6.dp, vertical = 3.dp)
            )

            if (index != genres.lastIndex) {
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}


@Composable
fun RateStars(voteAverage: Double, modifier: Modifier) {
    Row(modifier.padding(start = 4.dp)) {
        val maxVote = 10
        val starCount = 5
        repeat(starCount) { starIndex ->
            val voteStarCount = voteAverage / (maxVote / starCount)
            val asset = when {
                voteStarCount >= starIndex + 1 -> Icons.Filled.Star
                voteStarCount in starIndex.toDouble()..(starIndex + 1).toDouble() -> Icons.Filled.StarHalf
                else -> Icons.Filled.StarOutline
            }
            Icon(
                imageVector = asset,
                contentDescription = null,
                tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
}




