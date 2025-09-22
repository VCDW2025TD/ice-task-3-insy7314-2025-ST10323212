package com.example.memestream.data.api

import com.example.memestream.data.model.UserMeme
import retrofit2.Response
import retrofit2.http.*

interface UserMemeApiService {
    @GET("memes")
    suspend fun getUserMemes(): Response<List<UserMeme>>

    @POST("memes")
    suspend fun createMeme(@Body meme: UserMeme): Response<UserMeme>

    @DELETE("memes/{memeId}")
    suspend fun deleteMeme(@Path("memeId") memeId: String): Response<Unit>
}
