package com.example.memestream.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.memestream.data.model.UserMeme

@Dao
interface UserMemeDao {
    @Query("SELECT * FROM user_memes ORDER BY timestamp DESC")
    suspend fun getAllMemes(): List<UserMeme>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeme(meme: UserMeme)

    @Query("DELETE FROM user_memes WHERE id = :memeId")
    suspend fun deleteMemeById(memeId: String)
}
