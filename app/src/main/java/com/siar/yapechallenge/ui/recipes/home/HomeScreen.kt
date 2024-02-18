package com.siar.yapechallenge.ui.recipes.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siar.yapechallenge.R
import com.siar.yapechallenge.data.models.Recipes
import com.siar.yapechallenge.ui.recipes.UiRecipeState

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 14/02/2024
 *
 *****/
@Composable
fun HomeScreen(
    uiState: UiRecipeState
) {

    when (uiState){
        is UiRecipeState.Loading -> LoadingScreen()
        is UiRecipeState.Success -> {
            ResultScreen(uiState.recipes)
        }
        is UiRecipeState.Error -> ErrorScreen()
    }
}

@Composable
fun ResultScreen(recipes: List<Recipes>) {
    Text(text = "Success: ${recipes.size} recetas recibidas")
}

@Composable
fun LoadingScreen(){
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorScreen(){
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.wifi_error),
                contentDescription = "",
                modifier = Modifier.size(48.dp)
            )
            Text(
                text = stringResource(id = R.string.loading_failed),
                modifier = Modifier.padding(top = 16.dp),
                fontSize = 24.sp
            )
            Text(
                text = stringResource(id = R.string.try_again),
                fontSize = 12.sp
            )
        }
    }
}



@Preview(showSystemUi = true)
@Composable
fun RecipeCardPreview(){
    val lista: List<Recipes> = emptyList()
    ResultScreen(lista)
}
