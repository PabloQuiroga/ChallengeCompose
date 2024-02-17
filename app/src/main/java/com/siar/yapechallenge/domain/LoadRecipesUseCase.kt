package com.siar.yapechallenge.domain

import com.siar.yapechallenge.data.models.Recipes
import com.siar.yapechallenge.data.repository.RecipesRepository
import javax.inject.Inject

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 14/02/2024
 *
 *****/
class LoadRecipesUseCase @Inject constructor(
    private val repository: RecipesRepository
) {
    suspend operator fun invoke(): List<Recipes>? {
        return repository.getAllRecipes()
    }
}
