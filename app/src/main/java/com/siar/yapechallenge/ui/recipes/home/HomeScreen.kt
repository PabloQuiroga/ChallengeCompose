package com.siar.yapechallenge.ui.recipes.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siar.yapechallenge.R
import com.siar.yapechallenge.data.models.Recipes
import com.siar.yapechallenge.ui.recipes.UiRecipeState
import com.siar.yapechallenge.ui.recipes.components.RecipeBasicCard

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 14/02/2024
 *
 *****/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    uiState: UiRecipeState,
    onClickItem: (Recipes) -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.aqua),
                    titleContentColor = colorResource(id = R.color.navy)
                ),
                title = {
                    Text(
                        text = stringResource(R.string.list_title),
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            )
        },
        content = {
            when (uiState){
                is UiRecipeState.Loading -> LoadingScreen()
                is UiRecipeState.Success -> {
                    ResultScreen(uiState.recipes, onClickItem, it)
                }
                is UiRecipeState.Error -> ErrorScreen()
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(
    recipes: List<Recipes>,
    onClickItem: (Recipes) -> Unit,
    paddingValues: PaddingValues
) {
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    var recipeList by remember { mutableStateOf(recipes) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        color = colorResource(id = R.color.creamy_green)
    ) {
        Column {
            DockedSearchBar(
                query = query,
                onQueryChange = {query = it},
                onSearch = {
                    active = false
                },
                active = active,
                onActiveChange = {active = it},
                placeholder = {
                    Text(
                        text = "Buscar",
                        color = colorResource(id = R.color.purple_200)
                    )
                },
                trailingIcon = {
                   IconButton(onClick = { query = "" }) {
                       Icon(
                           imageVector = Icons.Default.Clear,
                           contentDescription = null,
                           tint = colorResource(id = R.color.navy)
                       )
                   }
                },
                shape = MaterialTheme.shapes.large,
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .padding(top = 8.dp)
            ) {
                val filteredRecipes = recipes.filter { it.name.contains(query, true) }
                recipeList = filteredRecipes
                LazyColumn{
                    items(filteredRecipes){
                        RecipeBasicCard(it) {
                            onClickItem(it)
                        }
                    }
                }
            }
            LazyColumn(
                modifier = Modifier
                    .padding(1.dp)
            ) {
                items(recipeList){
                    RecipeBasicCard(it) {
                        onClickItem(it)
                    }
                }
            }
        }
    }
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

