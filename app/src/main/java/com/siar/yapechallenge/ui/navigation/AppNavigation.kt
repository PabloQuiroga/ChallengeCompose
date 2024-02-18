package com.siar.yapechallenge.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.siar.yapechallenge.ui.recipes.details.DetailsScreen
import com.siar.yapechallenge.ui.recipes.home.HomeScreen
import com.siar.yapechallenge.ui.recipes.home.HomeViewModel
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
        val viewModel: HomeViewModel = hiltViewModel()
        HomeScreen(viewModel.uiState)
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
