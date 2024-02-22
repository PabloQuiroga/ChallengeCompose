package com.siar.yapechallenge.ui.map

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.siar.yapechallenge.data.models.Recipes
import com.siar.yapechallenge.ui.recipes.components.CustomTopBar

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 14/02/2024
 *
 *****/
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MapScreen(
    recipe: Recipes,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            CustomTopBar(title = "Mapa", backHandler = true, onBackClick)
        },
        content = {
            LoadMapContent(recipe)
        }
    )
}

@Composable
fun LoadMapContent(recipe: Recipes) {
    val marker = LatLng(recipe.geo.lat, recipe.geo.lng)
    val mapZoom = 9f
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(marker, mapZoom)
    }

    GoogleMap(
        modifier = Modifier
            .fillMaxSize(),
        cameraPositionState = cameraPositionState,
        properties = MapProperties(
            mapType = MapType.NORMAL
        )
    ){
        Marker(
            position = marker,
            title = recipe.name,
            snippet = recipe.description
        )
    }
}
