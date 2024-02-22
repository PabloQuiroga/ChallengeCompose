package com.siar.yapechallenge.mock

import com.siar.yapechallenge.data.repository.IRecipesRepository
import com.siar.yapechallenge.data.models.Recipes

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 18/02/2024
 *
 *****/
class MockRecipesApiService: IRecipesRepository {

    override suspend fun invoke(): List<Recipes> {
        return RecipesMockDataSource.recipesList
    }

}
