package com.example.weartur.domain.model.geocoder


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Geocoding(
    @SerialName("attribution")
    val attribution: String? = null,
    @SerialName("engine")
    val engine: Engine? = null,
    @SerialName("query")
    val query: Query? = null,
    @SerialName("timestamp")
    val timestamp: Long? = null,
    @SerialName("version")
    val version: String? = null
)