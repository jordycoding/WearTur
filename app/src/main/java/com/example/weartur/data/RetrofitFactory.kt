package com.example.weartur.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object RetrofitFactory {
    const val BASE_URL = "https://api.entur.io/geocoder/v1/"

    fun getGeocoderService(): GeocoderApi {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(Json.asConverterFactory(contentType)).build()
            .create(GeocoderApi::class.java)
    }
}