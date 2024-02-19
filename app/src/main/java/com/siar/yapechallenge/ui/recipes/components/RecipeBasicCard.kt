package com.siar.yapechallenge.ui.recipes.components

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
import com.siar.yapechallenge.data.models.Geo
import com.siar.yapechallenge.data.models.Ingredient
import com.siar.yapechallenge.data.models.NutritionalValues
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
                    text = recipes.name,
                    maxLines = 1,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                )
                Text(
                    text = recipes.description ?: "",
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
        recipes = Recipes(
            id = 4321,
            name = "receta dos",
            description = "descripcion de la segunda receta de pruebas",
            image = "url.dos",
            ingredients = listOf(
                Ingredient(
                "comino en polvo", "1/2 cucharada"
                ),
                Ingredient(
                "pechugas de pollo, sin hueso y sin piel", "1 lb"
                ),
                Ingredient(
                "melón, cortado en pedazos pequeños", "2 tazas"
                )
            ),
            steps = listOf(
                "En un recipiente pequeño, combina el jugo de naranja, el jugo de lima, el ajo y el comino. Mezcla bien. Coloca las pechugas de pollo y la mezcla de cítricos en una bolsa que se pueda sellar. Refrigera por 2 horas.",
                "Para la salsa, en un recipiente grande, combina el melón, el ají serrano y la cebolla. Salpimienta al gusto. Reserva.",
                "Rocía una parrilla con aerosol antiadherente. Calienta la parrilla a fuego medio. Saca las pechugas de la bolsa de plástico y desecha la marinada. Cocina las pechugas sobre la parrilla por 7-10 minutos en cada lado hasta que el pollo no esté rosado."
            ),
            servings = 4,
            values = listOf(
                NutritionalValues(
                    "carbs", "100g"
                ),
                NutritionalValues(
                    "protein", "1g"
                ),
                NutritionalValues(
                    "calories", "316.49 Kcal"
                )
            ),
            category = "vegetariano",
            geo = Geo(
                "-37.3159", "81.1496"
            )
        )
    ) {}
}
