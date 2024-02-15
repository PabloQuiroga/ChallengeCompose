package com.siar.yapechallenge.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.siar.yapechallenge.ui.details.DetailsScreen
import com.siar.yapechallenge.ui.home.HomeScreen
import com.siar.yapechallenge.ui.map.MapScreen

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 14/02/2024
 *
 *****/
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.HomeScreen.route
    ){
        addHomeScreen()
        addDetailsScreen()
        addMapScreen()
    }
}

fun NavGraphBuilder.addHomeScreen(){
    composable(
        AppScreens.HomeScreen.route
    ){
        HomeScreen()
    }
}

fun NavGraphBuilder.addDetailsScreen(){
    composable(
        AppScreens.DetailsScreen.route
    ){
        DetailsScreen()
    }
}

fun NavGraphBuilder.addMapScreen(){
    composable(
        AppScreens.MapScreen.route
    ){
        MapScreen()
    }
}