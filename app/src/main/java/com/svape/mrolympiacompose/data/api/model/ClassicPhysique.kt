package com.svape.mrolympiacompose.data.api.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class ClassicPhysique(
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
    @Json(name = "nickname")
    val nickname: String,
    @Json(name = "nationality")
    val nationality: String,
    @Json(name = "achievement")
    val achievement: String
) : Serializable