package com.cleanarchitecture.creativetask.presentation.moviedetail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MovieDetailScreen(

    viewModel: MovieDetailViewModel = hiltViewModel()

) {
    val state = viewModel.state.value
}
  //  Box(modifier = Modifier.fillMaxSize())
//        state.movie?.let { movie ->
//            LazyColumn(
//                modifier = Modifier.fillMaxSize(),
//                contentPadding = PaddingValues(20.dp)
//            ) {
//                item {
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.SpaceBetween
//                    ) {
//                        Text(
//                            text = "${movie.title}. ${movie.releaseDate} (${movie.id})",
//                            style = MaterialTheme.typography.h2,
//                            modifier = Modifier.weight(8f)
//                        )
//                    }
//                    Spacer(modifier = Modifier.height(15.dp))
//                    Text(
//                        text = movie.releaseDate,
//                        style = MaterialTheme.typography.body2
//                    )
//                    Spacer(modifier = Modifier.height(15.dp))
//                    Text(
//                        text = "Tags",
//                        style = MaterialTheme.typography.h3
//                    )
//                    Spacer(modifier = Modifier.height(15.dp))
////                    FlowRow(
////                        mainAxisSpacing = 10.dp,
////                        crossAxisSpacing = 10.dp,
////                        modifier = Modifier.fillMaxWidth()
////                    ) {
////                        coin.tags.forEach { tag ->
////                            CoinTag(tag = tag)
////                        }
////                    }
//                    Spacer(modifier = Modifier.height(15.dp))
//                    Text(
//                        text = "Team members",
//                        style = MaterialTheme.typography.h3
//                    )
//                    Spacer(modifier = Modifier.height(15.dp))
//                }
////                items(coin.team) { teamMember ->
////                    TeamListItem(
////                        teamMember = teamMember,
////                        modifier = Modifier
////                            .fillMaxWidth()
////                            .padding(10.dp)
////                    )
////                    Divider()
////                }
//            }
//        }
//        if(state.error.isNotBlank()) {
//            Text(
//                text = state.error,
//                color = MaterialTheme.colors.error,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 20.dp)
//                    .align(Alignment.Center)
//            )
//        }
//        if(state.isLoading) {
//            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
//        }
//    }
