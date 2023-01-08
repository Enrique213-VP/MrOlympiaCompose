package com.svape.mrolympiacompose.data.api.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MrOlympia(
    @Json(name = "Classic-Physique")
    val classicPhysique: List<ClassicPhysique>,
    @Json(name = "Legends")
    val legends: List<Legend>,
    @Json(name = "Open")
    val `open`: List<Open>
)