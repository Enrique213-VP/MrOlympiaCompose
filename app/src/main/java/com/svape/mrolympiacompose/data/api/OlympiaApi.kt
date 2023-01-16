package com.svape.mrolympiacompose.data.api

import com.svape.mrolympiacompose.data.api.model.ClassicPhysique
import retrofit2.http.GET

interface OlympiaApi {

    @GET(ApiConstants.EndPoint)
    suspend fun getOlympia(): List<ClassicPhysique>

}

