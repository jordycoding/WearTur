package com.example.weartur.domain.model.geocoder


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Feature(
    @SerialName("geometry")
    val geometry: Geometry? = null,
    @SerialName("properties")
    val properties: Properties? = null,
    @SerialName("type")
    val type: String? = null
)