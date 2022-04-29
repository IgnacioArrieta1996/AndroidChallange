package com.example.challangeandroid.domain.repository

import com.example.challangeandroid.data.local.entity.SoundEntity
import com.example.challangeandroid.domain.model.Sound
import kotlinx.coroutines.flow.Flow

interface IGetSoundListRoomRepository {

    suspend fun getSoundListFromRoom(): Flow<List<Sound>>

    suspend fun insertSoundList(soundList: List<SoundEntity>)
}