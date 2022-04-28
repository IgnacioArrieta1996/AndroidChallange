package com.example.challangeandroid.domain

import com.example.challangeandroid.data.network.response.SoundResponse
import com.example.challangeandroid.domain.model.Sound
import com.example.challangeandroid.domain.repository.IGetSoundListRepository
import com.highquality.base.data.Response
import com.highquality.base.domain.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetSoundUseCase @Inject constructor(private val repository: IGetSoundListRepository) :
    BaseUseCase<Flow<Response<List<Sound>>>>() {

    override suspend fun execute(): Flow<Response<List<Sound>>> {
        return repository.getSoundListFromApi()
    }


}
