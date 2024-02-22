package com.siar.yapechallenge.mock

import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 18/02/2024
 *
 *****/

class NetworkRecipesRepositoryTest {

    private lateinit var mockRepository: MockRecipesApiService

    @Before
    fun setup(){
        mockRepository = MockRecipesApiService()
    }

    @Test
    fun getRecipes_verifyRecipesList() = runTest{
        Assert.assertEquals(mockRepository(), RecipesMockDataSource.recipesList)
    }
}
