package com.siar.yapechallenge.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.siar.yapechallenge.data.models.Recipes
import com.siar.yapechallenge.ui.map.MapScreen
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
        addHomeScreen(navController)
        addDetailsScreen(navController)
        addMapScreen(navController)
    }
}

//screen composables definition
fun NavGraphBuilder.addHomeScreen(navController: NavHostController) {
    composable(
        AppScreens.HomeScreen.route
    ){
        val viewModel: HomeViewModel = hiltViewModel()
        HomeScreen(
            uiState = viewModel.uiState,
            onClickItem = { navigateToDetailsScreen(navController, objToJson(it)) },
            retryClick = { viewModel.loadRecipes() }
        )
    }
}

fun NavGraphBuilder.addDetailsScreen(navController: NavHostController){
    composable(
        AppScreens.DetailsScreen.route,
        arguments = listOf(navArgument("recipe") { defaultValue = "" })
    ){

        val argument = it.arguments?.getString("recipe")
        argument?.let {
            val recipe = jsonToObj(it)
            DetailsScreen(
                recipe = recipe,
                onClick = { navigateToMapScreen(navController, objToJson(it)) },
                onBackClick = { navController.popBackStack() }
            )
        }

    }
}

fun NavGraphBuilder.addMapScreen(navController: NavHostController){
    composable(
        AppScreens.MapScreen.route,
        arguments = listOf(navArgument("recipe") { defaultValue = "" })
    ){
        val argument = it.arguments?.getString("recipe")
        argument?.let {
            MapScreen(
                recipe = jsonToObj(it),
                onBackClick = { navController.popBackStack() }
            )
        }

    }
}

//navigation functions
fun navigateToDetailsScreen(navController: NavHostController, recipe: String){
    navController.navigate(AppScreens.DetailsScreen.createRoute(recipe))
}
fun navigateToMapScreen(navController: NavHostController, recipe: String){
    navController.navigate(AppScreens.MapScreen.createRoute(recipe))
}

// utilities
private fun objToJson(obj: Recipes) = Gson().toJson(obj)
private fun jsonToObj(json: String) = Gson().fromJson(json, Recipes::class.java)
