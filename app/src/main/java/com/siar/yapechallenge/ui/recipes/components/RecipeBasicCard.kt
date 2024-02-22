package com.siar.yapechallenge.ui.recipes.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.siar.yapechallenge.R
import com.siar.yapechallenge.data.models.Recipes

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 15/02/2024
 *
 *****/
@Composable
fun RecipeBasicCard(
    recipes: Recipes,
    onClick: () -> Unit,
) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(2.dp, colorResource(id = R.color.navy)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, start = 12.dp, end = 12.dp)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
        ) {
                SubcomposeAsyncImage(
                    model = recipes.image ?: R.drawable.recipes_cookbook,
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .weight(1f)
                        .size(60.dp, 90.dp)
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

            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 12.dp, bottom = 18.dp)
            ) {
                Text(
                    text = recipes.name,
                    maxLines = 1,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    color = colorResource(id = R.color.navy)
                )
                Text(
                    text = recipes.description ?: "",
                    maxLines = 2,
                    modifier = Modifier
                        .padding(horizontal = 8.dp),
                    overflow = TextOverflow.Ellipsis,
                    color = colorResource(id = R.color.navy)
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = "icon view details",
                modifier = Modifier
                    .align(alignment = Alignment.Bottom),
                tint = colorResource(id = R.color.navy)
            )
        }
    }
}
