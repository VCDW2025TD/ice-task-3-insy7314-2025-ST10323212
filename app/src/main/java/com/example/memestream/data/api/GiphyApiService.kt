package com.example.memestream.data.api

import com.example.memestream.data.model.GiphyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyApiService {
    @GET("trending")
    suspend fun getTrendingMemes(
        @Query("api_key") apiKey: String,
        @Query("limit") limit: Int = 20,
        @Query("rating") rating: String = "g"
    ): Response<GiphyResponse>

    @GET("search")
    suspend fun searchMemes(
        @Query("api_key") apiKey: String,
        @Query("q") query: String,
        @Query("limit") limit: Int = 20,
        @Query("rating") rating: String = "g"
    ): Response<GiphyResponse>
}
