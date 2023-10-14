package com.example.weartur.domain.model.geocoder


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Geometry(
    @SerialName("coordinates")
    val coordinates: List<Double?>? = null,
    @SerialName("type")
    val type: String? = null
)