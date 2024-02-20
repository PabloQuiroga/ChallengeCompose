package com.siar.yapechallenge.ui.recipes.details

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.siar.yapechallenge.R
import com.siar.yapechallenge.data.models.Ingredient
import com.siar.yapechallenge.data.models.NutritionalValues
import com.siar.yapechallenge.data.models.Recipes
import com.siar.yapechallenge.ui.recipes.components.Mockdata

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 20/02/2024
 *****/
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Suppress("EmptyFunctionBlock") // TODO just for now
@Composable
fun DetailsScreen(
    recipe: Recipes
){
    Scaffold(
        topBar = {

        },
        content = {
            LoadContent(recipe = recipe)
        }
    )
}

@Composable
fun LoadContent(recipe: Recipes){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
    ) {
        LoadImage(img = recipe.image)
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = recipe.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 3,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis

        )
        Text(
            text = recipe.description ?: "",
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        LoadTextChips(resource = recipe.category, identifier = stringResource(id = R.string.category))
        LoadTextChips(resource = recipe.servings.toString(), identifier = stringResource(id = R.string.servings))

        LoadIngredients(ingredients = recipe.ingredients)

    }
}

@Composable
fun LoadTextChips(resource: String, identifier: String){
    if (resource.isNotEmpty()){
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Blue)) {
                    append("$identifier ")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(resource)
                }
            },
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp),
            fontSize = 16.sp
        )
    }
}

@Composable
fun LoadImage(img: String?){
    SubcomposeAsyncImage(
        model = img ?: R.drawable.recipes_cookbook,
        contentDescription = "",
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    ) {
        when (painter.state) {
            is AsyncImagePainter.State.Error -> {
                Image(
                    painter = painterResource(id = R.drawable.recipes_cookbook),
                    contentDescription = ""
                )
            }

            is AsyncImagePainter.State.Loading -> {
                CircularProgressIndicator(modifier = Modifier.wrapContentSize())
            }

            else -> SubcomposeAsyncImageContent()
        }
    }
}

@Composable
fun LoadIngredients(ingredients: List<Ingredient>){

}

@Composable
fun LoadNutritionalValues(values: List<NutritionalValues>){

}

/**
 * Preview area
 */
@Preview(showBackground = true)
@Composable
fun LoadTextChipsPreview(){
    LoadTextChips(resource = "Demos", identifier = stringResource(id = R.string.servings))
}

@Preview(showSystemUi = true)
@Composable
fun DetailsScreenPreview(){
    DetailsScreen(recipe = Mockdata.recipeOne)
}