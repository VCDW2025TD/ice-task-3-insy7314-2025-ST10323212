package com.example.memestream.data.model

data class GiphyResponse(
    val data: List<GiphyMemeData>
)

data class GiphyMemeData(
    val id: String,
    val title: String?,
    val images: GiphyImages
)

data class GiphyImages(
    val original: GiphyImageDetail?,
    val preview: GiphyImageDetail?
)

data class GiphyImageDetail(
    val url: String,
    val width: String?,
    val height: String?
)
