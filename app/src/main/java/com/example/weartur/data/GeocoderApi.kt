package com.example.weartur.data

import com.example.weartur.domain.model.geocoder.AutocompleteResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GeocoderApi {
    @GET("autocomplete")
    @Headers("ET-Client-Name: alkema-weartur")
    suspend fun search(
        @Query("text") text: String,
        @Query("size") size: Int = 20,
        @Query("lang") lang: String = "no"
    ): Response<AutocompleteResponse>
}