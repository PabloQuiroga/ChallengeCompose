package com.siar.yapechallenge.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavArgument
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.siar.yapechallenge.ui.map.MapScreen
import com.siar.yapechallenge.ui.recipes.components.Mockdata
import com.siar.yapechallenge.ui.recipes.details.DetailsScreen
import com.siar.yapechallenge.ui.recipes.home.HomeScreen
import com.siar.yapechallenge.ui.recipes.home.HomeViewModel

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
        HomeScreen(viewModel.uiState){
            Log.e(it.name, it.toString()) //TODO
        }
    }
}

fun NavGraphBuilder.addDetailsScreen(){
    composable(
        AppScreens.DetailsScreen.route,
        arguments = listOf(navArgument("mediaId") { type = NavType.IntType })
    ){
        DetailsScreen(
            Mockdata.recipeOne //TODO
        )
    }
}

fun NavGraphBuilder.addMapScreen(){
    composable(
        AppScreens.MapScreen.route
    ){
        MapScreen(
            //TODO
            name = Mockdata.nameOne,
            desc = Mockdata.descOne,
            geo = Mockdata.geoOne
        )
    }
}
