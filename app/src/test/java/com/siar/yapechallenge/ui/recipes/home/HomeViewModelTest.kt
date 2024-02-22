package com.siar.yapechallenge.ui.recipes.home

import com.siar.yapechallenge.data.MockRecipesRepository
import com.siar.yapechallenge.mock.RecipesMockDataSource
import com.siar.yapechallenge.rules.TestDispatcherRule
import com.siar.yapechallenge.ui.recipes.UiRecipeState
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test


/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 18/02/2024
 *
 */
class HomeViewModelTest{

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun getRecipes_verifyRecipesUiStateSuccess() = runTest {
        val viewmodel = HomeViewModel(
            repository = MockRecipesRepository()
        )
        assertEquals(
            UiRecipeState.Success(RecipesMockDataSource.recipesList), viewmodel.uiState
        )
    }
}
