package com.example.weartur.domain.repository

import com.example.weartur.domain.model.geocoder.AutocompleteResponse
import com.example.weartur.domain.model.geocoder.Feature

interface GeocoderRepository {
    suspend fun search(text: String, size: Int = 20, lang: String = "no"): AutocompleteResponse?
    fun findById(id: String): Feature?
}