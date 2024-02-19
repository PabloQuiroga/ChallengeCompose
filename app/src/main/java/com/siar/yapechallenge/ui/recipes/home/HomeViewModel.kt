package com.siar.yapechallenge.ui.recipes.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siar.yapechallenge.data.IRecipesRepository
import com.siar.yapechallenge.ui.recipes.UiRecipeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 14/02/2024
 *
 *****/
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: IRecipesRepository
): ViewModel(){

    var uiState: UiRecipeState by mutableStateOf(UiRecipeState.Loading)
        private set

    init {
        getRecipes()
    }

    private fun getRecipes(){
        viewModelScope.launch {
            uiState = UiRecipeState.Loading

            uiState = try{
                val result = repository()
                UiRecipeState.Success(result)
            } catch (e: IOException){
                UiRecipeState.Error
            }
        }
    }
}
