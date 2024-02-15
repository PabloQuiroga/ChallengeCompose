package com.siar.yapechallenge.ui.navigation

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 14/02/2024
 *
 *****/
const val HOME_SCREEN = "home_screen"
const val DETAILS_SCREEN = "detail_screen"
const val MAP_SCREEN = "map_screen"

sealed class AppScreens(val route: String) {
    object HomeScreen: AppScreens(HOME_SCREEN)
    object DetailsScreen: AppScreens(DETAILS_SCREEN)
    object MapScreen: AppScreens(MAP_SCREEN)
}
