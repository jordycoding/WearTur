package com.example.weartur.domain.model.geocoder


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AutocompleteResponse(
    @SerialName("bbox")
    val bbox: List<Double?>? = null,
    @SerialName("features")
    val features: List<Feature?>? = null,
    @SerialName("geocoding")
    val geocoding: Geocoding? = null,
    @SerialName("type")
    val type: String? = null
)