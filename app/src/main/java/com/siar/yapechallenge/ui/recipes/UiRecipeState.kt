package com.siar.yapechallenge.ui.recipes

import com.siar.yapechallenge.data.models.Recipes

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 16/02/2024
 *
 *****/
sealed interface UiRecipeState {
    data class Success(val recipes: List<Recipes>) : UiRecipeState
    object Loading : UiRecipeState
    object Error : UiRecipeState
}