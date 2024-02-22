package com.siar.yapechallenge.data

import com.siar.yapechallenge.data.models.Recipes
import com.siar.yapechallenge.data.repository.IRecipesRepository
import com.siar.yapechallenge.mock.RecipesMockDataSource


/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 18/02/2024
 *
 */
class MockRecipesRepository: IRecipesRepository {

    override suspend fun invoke(): List<Recipes> {
        return RecipesMockDataSource.recipesList
    }
}
