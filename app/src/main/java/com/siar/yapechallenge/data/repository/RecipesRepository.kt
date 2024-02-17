package com.siar.yapechallenge.data.repository

import com.siar.yapechallenge.data.models.Recipes
import com.siar.yapechallenge.data.services.RecipesService
import javax.inject.Inject

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 16/02/2024
 *
 *****/
class RecipesRepository @Inject constructor(
    private val api: RecipesService
) {
    suspend fun getAllRecipes(): List<Recipes>? {
        return api.getRecipes()
    }
}
