package com.svape.mrolympiacompose.data.api

import com.svape.mrolympiacompose.data.api.model.MrOlympia
import retrofit2.http.GET

interface OlympiaApi {

    @GET()
    suspend fun getOlympia():List<MrOlympia>
}