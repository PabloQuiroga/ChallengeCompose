package com.siar.yapechallenge.data

import com.siar.yapechallenge.data.models.Recipes
import com.siar.yapechallenge.data.services.RecipesService
import kotlinx.coroutines.delay
import javax.inject.Inject

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 16/02/2024
 *
 *****/
class RecipesRepository @Inject constructor(
    private val api: RecipesService
): IRecipesRepository {

    override suspend operator fun invoke(): List<Recipes> {
        delay(3000) //TODO only for demo
        return api.getRecipes()
    }

    suspend fun getRecipes(): List<Recipes> {
        return api.getRecipes()
    }
}
