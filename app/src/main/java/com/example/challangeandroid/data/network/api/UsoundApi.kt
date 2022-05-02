package com.example.challangeandroid.data.network.api

import com.example.challangeandroid.BuildConfig
import com.example.challangeandroid.data.network.response.SoundResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface UsoundApi {
    @Headers(
        "Content-Type: application/json; charset=utf-8",
        "Authorization: ${BuildConfig.API_KEY}"
    )
    @GET("api/repited-tone/")
    suspend fun getSounds(): Response<List<SoundResponse>>

}