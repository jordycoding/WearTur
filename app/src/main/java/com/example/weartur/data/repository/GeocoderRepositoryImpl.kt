package com.example.weartur.data.repository

import com.example.weartur.data.GeocoderApi
import com.example.weartur.domain.model.geocoder.AutocompleteResponse
import com.example.weartur.domain.model.geocoder.Feature
import com.example.weartur.domain.repository.GeocoderRepository

class GeocoderRepositoryImpl(private val geocoderApi: GeocoderApi) : GeocoderRepository {

    private lateinit var searchResult: AutocompleteResponse
    override suspend fun search(text: String, size: Int, lang: String): AutocompleteResponse? {
        val res = geocoderApi.search(text, size, lang).body()
        if (res != null) {
            searchResult = res
        }
        return res
    }

    override fun findById(id: String): Feature? {
        return searchResult.features?.findLast { it?.properties?.id == id }
    }
}