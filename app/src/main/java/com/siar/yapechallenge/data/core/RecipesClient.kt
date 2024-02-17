package com.siar.yapechallenge.data.core

import com.siar.yapechallenge.data.models.Recipes
import retrofit2.Response
import retrofit2.http.GET

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 15/02/2024
 *
 *****/
interface RecipesClient {

    @GET("recipes")
    suspend fun getAllRecipes(): Response<List<Recipes>>
}
