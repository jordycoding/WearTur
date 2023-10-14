package com.example.weartur.domain.model.geocoder


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Engine(
    @SerialName("author")
    val author: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("version")
    val version: String? = null
)