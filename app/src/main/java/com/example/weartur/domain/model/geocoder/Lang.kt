package com.example.weartur.domain.model.geocoder


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Lang(
    @SerialName("defaulted")
    val defaulted: Boolean? = null,
    @SerialName("iso6391")
    val iso6391: String? = null,
    @SerialName("iso6393")
    val iso6393: String? = null,
    @SerialName("name")
    val name: String? = null
)