package com.example.challangeandroid.domain.repository

import com.example.challangeandroid.domain.model.Sound
import com.highquality.base.data.Response
import kotlinx.coroutines.flow.Flow

interface IGetSoundListRepository {

    suspend fun getSoundListFromApi(): Flow<Response<List<Sound>>>


}