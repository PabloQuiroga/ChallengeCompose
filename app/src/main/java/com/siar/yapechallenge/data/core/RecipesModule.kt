package com.siar.yapechallenge.data.core

import com.siar.yapechallenge.data.repository.IRecipesRepository
import com.siar.yapechallenge.data.repository.RecipesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 18/02/2024
 *
 *****/
@Module
@InstallIn(SingletonComponent::class)
class RecipesModule {

    @Provides
    fun bindRecipesRepository(repository: RecipesRepository): IRecipesRepository {
        return repository
    }

}
