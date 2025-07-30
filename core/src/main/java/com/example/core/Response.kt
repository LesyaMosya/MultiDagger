package com.example.core

import com.google.gson.annotations.SerializedName

data class SizesResponse (
    @SerializedName("sizes")
    val sizes: Sizes
)

data class Sizes(
    @SerializedName("size")
    val size: List<Size>
)

data class Size(
    @SerializedName("label")
    val label: String,
    @SerializedName("width")
    val width: Int,
    @SerializedName("height")
    val height: Int,
    @SerializedName("source")
    val source: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("media")
    val media: String
)