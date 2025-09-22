package com.example.memestream.data.repository

import com.example.memestream.data.local.UserMemeDao
import com.example.memestream.data.model.UserMeme

class UserMemeRepository(private val memeDao: UserMemeDao) {

    suspend fun getAllUserMemes(): List<UserMeme> {
        return memeDao.getAllMemes()
    }

    suspend fun saveUserMeme(meme: UserMeme) {
        memeDao.insertMeme(meme)
    }

    suspend fun deleteUserMeme(memeId: String) {
        memeDao.deleteMemeById(memeId)
    }
}
