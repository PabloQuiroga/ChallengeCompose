package com.siar.yapechallenge.data

import com.siar.yapechallenge.data.models.Recipes

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 18/02/2024
 *
 *****/
interface IRecipesRepository {
    suspend operator fun invoke(): List<Recipes>
    //suspend fun getRecipes(): List<Recipes>
}