package com.siar.yapechallenge.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siar.yapechallenge.data.models.Recipes
import com.siar.yapechallenge.domain.LoadRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 14/02/2024
 *
 *****/
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val loadRecipesUseCase: LoadRecipesUseCase
): ViewModel(){
    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _recipesList = MutableStateFlow(listOf<Recipes>())
    val recipesList = _recipesList.asStateFlow()

    init {
        updateRecipesList()
    }

    private fun updateRecipesList(){
        viewModelScope.launch {
            _isLoading.value = true

            val result = loadRecipesUseCase()
            if(!result.isNullOrEmpty()) _recipesList.value = result

            _isLoading.value = false
        }
    }
}
