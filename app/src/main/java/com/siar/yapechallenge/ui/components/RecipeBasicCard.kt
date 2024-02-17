package com.siar.yapechallenge.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siar.yapechallenge.R
import com.siar.yapechallenge.ui.home.BasicRecipeState

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 15/02/2024
 *
 *****/
@Composable
fun RecipeBasicCard(
    onClick: () -> Unit
) {
    OutlinedCard(
    colors = CardDefaults.cardColors(
    containerColor = MaterialTheme.colorScheme.surface,
    ),
    border = BorderStroke(2.dp, Color.Blue),
    modifier = Modifier
        .fillMaxWidth()
        .padding(top = 12.dp, start = 12.dp, end = 12.dp)
        .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.recipes_cookbook),
                contentDescription = "imagen comida",
                modifier = Modifier
                    .weight(1f),
                Alignment.Center
            )
            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxWidth()
                    .padding(start = 8.dp),
            ) {
                Text(
                    text = "nombre receta",
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                )
                Text(
                    text = "descripcion de la \ncomida",
                    maxLines = 2,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.arrow_right),
                    contentDescription = "icon view details",
                    modifier = Modifier
                        .align(alignment = Alignment.End)
                )
            }
        }
    }
}

@Preview
@Composable
fun RecipeMiniCardPreview(){
    RecipeBasicCard(
        state = BasicRecipeState()
    ) {
        // nothin in preview
    }
}
