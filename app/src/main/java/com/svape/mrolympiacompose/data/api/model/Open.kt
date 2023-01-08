package com.svape.mrolympiacompose.data.api.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Open(
    @Json(name = "Birth")
    val birth: Int,
    @Json(name = "id")
    val id: Int,
    @Json(name = "imageP")
    val imageP: String,
    @Json(name = "imageTa")
    val imageTa: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "nationality")
    val nationality: String,
    @Json(name = "win_mister_olympia")
    val winMisterOlympia: String
)