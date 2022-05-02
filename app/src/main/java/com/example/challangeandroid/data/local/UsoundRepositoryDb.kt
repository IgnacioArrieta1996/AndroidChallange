package com.example.challangeandroid.data.local

import com.example.challangeandroid.data.local.dao.SoundDao
import com.example.challangeandroid.data.local.entity.SoundEntity
import com.example.challangeandroid.domain.model.Sound
import com.example.challangeandroid.domain.model.toDomain
import com.example.challangeandroid.domain.repository.IGetSoundListRoomRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UsoundRepositoryDb @Inject constructor(private val usoundDao: SoundDao) :
    IGetSoundListRoomRepository {

    override suspend fun getSoundListFromRoom(): Flow<List<Sound>> = flow {

        val response: List<SoundEntity> = usoundDao.getAllSounds()

        emit(response.map { it.toDomain() })

    }

    override suspend fun insertSoundList(soundList: List<SoundEntity>) {
        usoundDao.insertAllSounds(soundList)
    }


}