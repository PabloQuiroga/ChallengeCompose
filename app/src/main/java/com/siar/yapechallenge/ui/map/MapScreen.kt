package com.siar.yapechallenge.ui.map

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.siar.yapechallenge.data.models.Geo

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 14/02/2024
 *
 *****/
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MapScreen(
    name: String,
    desc: String,
    geo: Geo
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Mapa")
                }
            )
        },
        content = {
            LoadMapContent(name, desc, geo)
        }
    )
}

@Composable
fun LoadMapContent(name: String, desc: String, geo: Geo) {
    val marker = LatLng(geo.lat, geo.lng)
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
            title = name,
            snippet = desc
        )
    }
}
