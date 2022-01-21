package com.cleanarchitecture.creativetask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.cleanarchitecture.creativetask.presentation.movielist.MovieListScreen
import com.cleanarchitecture.creativetask.presentation.search.SearchView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //    CryptocurrencyAppYTTheme {
            Surface(color = MaterialTheme.colors.background) {

                Scaffold(
                    topBar = { TopBar() },
                    backgroundColor = colorResource(id = R.color.dark_gray)
                ) {
                     Navigation()
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
        backgroundColor = colorResource(id = R.color.white),
        contentColor = Color.White
    )
}

@Composable
fun MainScreen(navController: NavController) {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    Column {
        SearchView(textState)
        MovieListScreen(navController = navController, stateTextField = textState)
    }
}

@Composable
fun DetailsScreen(id: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.medium_gray))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = id,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 22.sp
        )
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(navController = navController)
        }
        composable(
            "details/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("id")?.let { id ->
                DetailsScreen(id = id)
            }
        }
    }
}





