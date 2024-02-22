package com.siar.yapechallenge.mock

import com.siar.yapechallenge.data.models.Geo
import com.siar.yapechallenge.data.models.Item
import com.siar.yapechallenge.data.models.Recipes

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 18/02/2024
 *
 *****/
object RecipesMockDataSource {
    const val idOne = 1234
    const val nameOne = "receta uno"
    const val descOne = "descripcion de la receta de pruebas numero uno"
    const val imgOne = "url.uno"
    val ingredientsOne = listOf(
        Item(
            "jugo de naranja, recién exprimido", "1/4 taza"
        ),
        Item(
            "jugo de lima, recién exprimido", "1/4 taza"
        ),
        Item(
            "ajo grande, picado", "1 diente"
        )
    )
    val instructionsOne = listOf(
        "Para la salsa, en un recipiente grande, combina el melón, el ají serrano y la cebolla. Salpimienta al gusto. Reserva.",
        "Rocía una parrilla con aerosol antiadherente. Calienta la parrilla a fuego medio. Saca las pechugas de la bolsa de plástico y desecha la marinada. Cocina las pechugas sobre la parrilla por 7-10 minutos en cada lado hasta que el pollo no esté rosado.",
        "Sirve con la salsa de melón. Disfruta."
    )
    const val servingsOne = 1
    val valuesOne = listOf(
        Item(
            "calories", "316.49 Kcal"

        ),
        Item(
            "protein", "0g"
        ),
        Item(
            "carbs", "100g"
        )
    )
    const val categoryOne = "carnes"
    val geoOne = Geo(
        -34.517610, -58.771136
    )

    const val idTwo = 4321
    const val nameTwo = "receta dos"
    const val descTwo = "descripcion de la segunda receta de pruebas"
    const val imgTwo = "url.dos"
    val ingregientsTwo = listOf(
        Item(
            "comino en polvo", "1/2 cucharada"
        ),
        Item(
            "pechugas de pollo, sin hueso y sin piel", "1 lb"
        ),
        Item(
            "melón, cortado en pedazos pequeños", "2 tazas"
        )
    )
    val instructionsTwo = listOf(
        "En un recipiente pequeño, combina el jugo de naranja, el jugo de lima, el ajo y el comino. Mezcla bien. Coloca las pechugas de pollo y la mezcla de cítricos en una bolsa que se pueda sellar. Refrigera por 2 horas.",
        "Para la salsa, en un recipiente grande, combina el melón, el ají serrano y la cebolla. Salpimienta al gusto. Reserva.",
        "Rocía una parrilla con aerosol antiadherente. Calienta la parrilla a fuego medio. Saca las pechugas de la bolsa de plástico y desecha la marinada. Cocina las pechugas sobre la parrilla por 7-10 minutos en cada lado hasta que el pollo no esté rosado."
    )
    const val servingsTwo = 4
    val valuesTwo = listOf(
        Item(
            "carbs", "100g"
        ),
        Item(
            "protein", "1g"
        ),
        Item(
            "calories", "316.49 Kcal"
        )
    )
    const val categoryTwo = "vegetariano"
    val geoTwo = Geo(
        -37.3159, 81.1496
    )


    val recipesList = listOf(
        Recipes(
            idOne,
            nameOne,
            descOne,
            imgOne,
            instructionsOne,
            ingredientsOne,
            valuesOne,
            categoryOne,
            servingsOne,
            geoOne
        ),
        Recipes(
            idTwo,
            nameTwo,
            descTwo,
            imgTwo,
            instructionsTwo,
            ingregientsTwo,
            valuesTwo,
            categoryTwo,
            servingsTwo,
            geoTwo
        )
    )
}