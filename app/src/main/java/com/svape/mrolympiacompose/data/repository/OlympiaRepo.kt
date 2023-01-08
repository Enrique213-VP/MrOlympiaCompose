package com.svape.mrolympiacompose.data.repository

import com.svape.mrolympiacompose.data.api.OlympiaApi
import com.svape.mrolympiacompose.data.api.model.MrOlympia
import javax.inject.Inject

class OlympiaRepo @Inject constructor(
    private val olympiaApi: OlympiaApi
) {
    suspend fun getOlympias():List<MrOlympia>{
        return olympiaApi.getOlympia()
    }
}