package com.siar.yapechallenge.data.models

import com.google.gson.annotations.SerializedName

/*****
 * Project: Yape Challenge
 * Created by: Pablo Daniel Quiroga
 * Last update: 15/02/2024
 *
 *****/
data class Recipes(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("desc")
    val description: String?,
    @SerializedName("img")
    val image: String?,
    @SerializedName("instructions")
    val steps: List<String>,
    @SerializedName("ingredients")
    val ingredients: List<Item>,
    @SerializedName("values")
    val values: List<Item> = emptyList(),
    @SerializedName("category")
    val category: String,
    @SerializedName("servings")
    val servings: Int,
    @SerializedName("geo")
    val geo: Geo
)

data class Item(
    @SerializedName("name")
    val item: String,
    @SerializedName("quantity")
    val quantity: String
)

data class Geo (
    @SerializedName("lat")
    var lat: Double,
    @SerializedName("lng")
    var lng: Double
)
