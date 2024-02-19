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
    @SerializedName("image")
    val image: String?,
    @SerializedName("ingredients")
    val ingredients: List<Ingredient>,
    @SerializedName("steps")
    val steps: List<String>,
    @SerializedName("values")
    val values: List<NutritionalValues>,
    @SerializedName("category")
    val category: String,
    @SerializedName("servings")
    val servings: Int,
    @SerializedName("geo")
    val geo: Geo
)

data class Ingredient(
    @SerializedName("name")
    val item: String,
    @SerializedName("quantity")
    val quantity: String
)

data class NutritionalValues(
    @SerializedName("item")
    val item: String,
    @SerializedName("value")
    val value: String
)

data class Geo (
    @SerializedName("lat")
    var lat: String,
    @SerializedName("lng")
    var lng: String
)