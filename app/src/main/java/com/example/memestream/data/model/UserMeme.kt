package com.example.memestream.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_memes")
data class UserMeme(
    @PrimaryKey val id: String,
    val imageUrl: String,
    val caption: String,
    val latitude: Double,
    val longitude: Double,
    val timestamp: Long = System.currentTimeMillis()
)
