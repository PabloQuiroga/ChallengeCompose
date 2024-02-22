package com.siar.yapechallenge.ui.navigation

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 14/02/2024
 *
 *****/
const val HOME_SCREEN = "home_screen"
const val DETAILS_SCREEN = "detail_screen?recipe={recipe}"
const val MAP_SCREEN = "map_screen?recipe={recipe}"

sealed class AppScreens(val route: String) {
    object HomeScreen: AppScreens(HOME_SCREEN)
    object DetailsScreen: AppScreens(DETAILS_SCREEN){
        fun createRoute(recipe: String) = "detail_screen?recipe=$recipe"
    }
    object MapScreen: AppScreens(MAP_SCREEN){
        fun createRoute(recipe: String) = "map_screen?recipe=$recipe"
    }
}
