package com.siar.yapechallenge.data.services

import com.siar.yapechallenge.data.core.RecipesClient
import com.siar.yapechallenge.data.models.Recipes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 16/02/2024
 *
 *****/
class RecipesService @Inject constructor(
    private val recipesClient: RecipesClient
) {
    suspend fun getRecipes(): List<Recipes>{
        return withContext(Dispatchers.IO){
            val response = recipesClient.getAllRecipes()
            response.body() ?: emptyList()
        }
    }
}
