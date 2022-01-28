package com.cleanarchitecture.creativetask.route


sealed class Screen(val route: String) {
    object MovieListScreen: Screen("main")
    object MovieDetailScreen: Screen("details")
}

