package com.example.challangeandroid.domain

import com.example.challangeandroid.data.local.entity.SoundEntity
import com.example.challangeandroid.data.network.response.SoundResponse
import com.example.challangeandroid.domain.model.Sound
import com.example.challangeandroid.domain.repository.IGetSoundListRepository
import com.example.challangeandroid.domain.repository.IGetSoundListRoomRepository
import com.highquality.base.data.Response
import com.highquality.base.domain.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetSoundUseCase @Inject constructor(private val repository: IGetSoundListRepository, private val roomRepo: IGetSoundListRoomRepository) :
    BaseUseCase<Flow<Response<List<Sound>>>>() {

    override suspend fun execute(): Flow<Response<List<Sound>>> {
        return repository.getSoundListFromApi()
    }

    suspend fun getSoundsFromRoomDb() : Flow<List<Sound>> = roomRepo.getSoundListFromRoom()

    suspend fun insertSoundList(list: List<SoundEntity>){
        roomRepo.insertSoundList(list)
    }


}
