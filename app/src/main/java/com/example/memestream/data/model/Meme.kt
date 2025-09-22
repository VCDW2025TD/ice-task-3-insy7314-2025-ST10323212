package com.example.memestream.data.model

data class Meme(
    val id: String,
    val title: String?,
    val url: String,
    val previewUrl: String?,
    val width: Int?,
    val height: Int?
)
