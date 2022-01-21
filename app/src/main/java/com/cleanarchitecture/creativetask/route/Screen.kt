package com.cleanarchitecture.creativetask.route


sealed class Screen(val route: String) {
    object MovieListScreen: Screen("movie_list_screen")
    object MovieDetailScreen: Screen("movie_detail_screen")
}
