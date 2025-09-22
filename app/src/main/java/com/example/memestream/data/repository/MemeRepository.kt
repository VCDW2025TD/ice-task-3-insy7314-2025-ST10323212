package com.example.memestream.data.repository

import com.example.memestream.data.api.GiphyApiService
import com.example.memestream.data.model.Meme
import com.example.memestream.data.model.GiphyResponse
import com.example.memestream.data.model.GiphyMemeData
import com.example.memestream.data.model.GiphyImages
import com.example.memestream.data.model.GiphyImageDetail
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MemeRepository {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.giphy.com/v1/gifs/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    private val apiService = retrofit.create(GiphyApiService::class.java)

    suspend fun getTrendingMemes(apiKey: String): List<Meme> {
        return try {
            val response = apiService.getTrendingMemes(apiKey)
            if (response.isSuccessful) {
                response.body()?.data?.map { memeData ->
                    Meme(
                        id = memeData.id,
                        title = memeData.title,
                        url = memeData.images.original?.url ?: "",
                        previewUrl = memeData.images.preview?.url,
                        width = memeData.images.original?.width?.toIntOrNull(),
                        height = memeData.images.original?.height?.toIntOrNull()
                    )
                } ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun searchMemes(apiKey: String, query: String): List<Meme> {
        return try {
            val response = apiService.searchMemes(apiKey, query)
            if (response.isSuccessful) {
                response.body()?.data?.map { memeData ->
                    Meme(
                        id = memeData.id,
                        title = memeData.title,
                        url = memeData.images.original?.url ?: "",
                        previewUrl = memeData.images.preview?.url,
                        width = memeData.images.original?.width?.toIntOrNull(),
                        height = memeData.images.original?.height?.toIntOrNull()
                    )
                } ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}
