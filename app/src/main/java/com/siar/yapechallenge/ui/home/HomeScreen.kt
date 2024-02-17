package com.siar.yapechallenge.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 14/02/2024
 *
 *****/
@Composable
fun HomeScreen() {
    //val viewModel: HomeViewModel = hiltViewModel()
    //val recipes = viewModel.recipesList.collectAsState()

    LazyColumn(content = {})
}





@Preview(showSystemUi = true)
@Composable
fun RecipeCardPreview(){
    HomeScreen()
}
