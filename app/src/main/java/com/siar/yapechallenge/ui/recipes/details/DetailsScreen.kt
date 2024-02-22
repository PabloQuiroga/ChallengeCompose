package com.siar.yapechallenge.ui.recipes.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
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
import com.siar.yapechallenge.data.models.Item
import com.siar.yapechallenge.data.models.Recipes
import com.siar.yapechallenge.ui.recipes.components.CustomTopBar

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 20/02/2024
 *****/
@Composable
fun DetailsScreen(
    recipe: Recipes,
    onClick: (Recipes) -> Unit,
    onBackClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            CustomTopBar(title = "Detalles", backHandler = true, onBackClick)
        },
        content = {
            LoadContent(recipe = recipe, it, onClick)
        }
    )
}

@Composable
fun LoadContent(
    recipe: Recipes,
    paddingValues: PaddingValues,
    onClick: (Recipes) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .verticalScroll(state = rememberScrollState())
            .background(color = colorResource(id = R.color.creamy_green))
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
            overflow = TextOverflow.Ellipsis,
            color = colorResource(id = R.color.accent)
        )
        recipe.description?.let {
            Text(
                text = it,
                modifier = Modifier.padding(horizontal = 8.dp),
                color = colorResource(id = R.color.navy)
            )
        }

        LoadSteps(steps = recipe.steps)

        LoadIngredients(ingredients = recipe.ingredients)

        LoadNutritionalValues(values = recipe.values)

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            LoadTextChips(
                resource = recipe.category,
                identifier = stringResource(id = R.string.category)
            )
            Spacer(modifier = Modifier.padding(4.dp))
            LoadTextChips(
                resource = recipe.servings,
                identifier = stringResource(id = R.string.servings)
            )
        }

        if (recipe.geo.lat != 0.0) {
            Text(
                text = stringResource(R.string.location),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp, end = 16.dp)
                    .clickable {
                        onClick(recipe)
                    }
            )
        }
    }
}

@Composable
fun LoadTextChips(resource: Any, identifier: String) {
    if (resource.toString().isNotEmpty()) {
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.ExtraBold,
                        color = colorResource(id = R.color.navy)
                    )
                ) {
                    append("$identifier: ")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.coral)
                    )
                ) {
                    append(resource.toString())
                }
            },
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp),
            fontSize = 16.sp
        )
    }
}

@Composable
fun LoadImage(img: String?) {
    SubcomposeAsyncImage(
        model = img ?: R.drawable.recipes_cookbook,
        contentDescription = "",
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    ) {
        when (painter.state) {
            is AsyncImagePainter.State.Error -> {
                Image(
                    painter = painterResource(id = R.drawable.q_alphabet_round_icon),
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
fun LoadIngredients(ingredients: List<Item>) {
    if (ingredients.isNotEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            SetTitleSection(section = stringResource(id = R.string.ingredients))

            ingredients.forEach {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.CheckCircle,
                        contentDescription = "backHandler icon",
                        tint = colorResource(id = R.color.accent),
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = it.quantity + " " + it.item,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        overflow = TextOverflow.Ellipsis,
                        color = colorResource(id = R.color.navy)
                    )
                }
            }
        }
    }
}

@Composable
fun LoadSteps(steps: List<String>) {
    if (steps.isNotEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            SetTitleSection(section = stringResource(id = R.string.steps))

            steps.forEach {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = "backHandler icon",
                        tint = colorResource(id = R.color.accent),
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = it,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.navy)
                    )
                }
            }
        }
    }
}

@Composable
fun LoadNutritionalValues(values: List<Item>) {
    if (values.isNotEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            SetTitleSection(section = stringResource(id = R.string.nutritional_values))

            values.forEach {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 2.dp),
                ) {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = "backHandler icon",
                        tint = colorResource(id = R.color.coral),
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = "${it.item}: ",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.navy)
                    )
                    Text(
                        text = it.quantity,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.navy)
                    )
                }
            }
        }
    }
}

@Composable
fun SetTitleSection(section: String) {
    Text(
        modifier = Modifier
            .padding(bottom = 8.dp),
        text = section,
        fontSize = 16.sp,
        fontWeight = FontWeight.ExtraBold,
        color = colorResource(id = R.color.navy)
    )
}

/**
 * Preview area
 */
@Preview(showBackground = true)
@Composable
fun LoadTextChipsPreview() {
    LoadTextChips(resource = "Demos", identifier = stringResource(id = R.string.servings))
}
