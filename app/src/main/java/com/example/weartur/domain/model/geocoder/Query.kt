package com.example.weartur.domain.model.geocoder


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Query(
    @SerialName("lang")
    val lang: Lang? = null,
    @SerialName("layers")
    val layers: List<String?>? = null,
    @SerialName("parser")
    val parser: String? = null,
    @SerialName("private")
    val `private`: Boolean? = null,
    @SerialName("querySize")
    val querySize: Int? = null,
    @SerialName("size")
    val size: Int? = null,
    @SerialName("sources")
    val sources: List<String?>? = null,
    @SerialName("text")
    val text: String? = null,
    @SerialName("tokens")
    val tokens: List<String?>? = null
)