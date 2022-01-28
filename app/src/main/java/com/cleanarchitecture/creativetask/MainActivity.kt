package com.cleanarchitecture.creativetask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cleanarchitecture.creativetask.presentation.moviedetail.MovieDetailScreen
import com.cleanarchitecture.creativetask.presentation.movielist.MovieListScreen
import com.cleanarchitecture.creativetask.presentation.search.components.SearchView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Surface(color = MaterialTheme.colors.background) {

                Scaffold(
                    topBar = { TopBar() },
                    backgroundColor = colorResource(id = R.color.dark_gray)
                ) {
                    NavHost(navController = navController, startDestination = "main") {

                        composable("main") {
                            MainScreen(navController)
                        }
                        composable(
                            "details/{id}",

                        ) {
                            MovieDetailScreen()

                        }
                    }
                }


            }
        }

    }


    //    }
}
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp) },
        backgroundColor = Color.Red,
        contentColor = Color.White
    )
}

@Composable
fun MainScreen(navController: NavController) {
    val textState = remember { mutableStateOf(TextFieldValue("")) }

    Column {
        SearchView(textState)
        MovieListScreen(navController = navController)
    }
}

@Composable
fun HomeAppBar(title: String, openSearch: () -> Unit, openFilters: () -> Unit) {
    TopAppBar(
        title = { Text(text = title) },
        actions = {
            IconButton(onClick = openSearch) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
            }

            IconButton(onClick = openFilters) {
                Icon(imageVector = Icons.Filled.FilterList, contentDescription = "Filter")
            }
        }
    )
}

//@Composable
//fun DetailScreen(movie: ArrayList<CharSequence>) {
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(colorResource(id = R.color.medium_gray))
//            .wrapContentSize(Alignment.Center)
//    ) {
//        Text(
//            text =movie.title,
//            color = Color.White,
//            modifier = Modifier.align(Alignment.CenterHorizontally),
//            textAlign = TextAlign.Center,
//            fontSize = 22.sp
//        )
//    }
//}

//@Composable
//fun Navigation() {
//
//
//}
