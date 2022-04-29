package com.example.challangeandroid.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.challangeandroid.data.network.response.SoundResponse
import com.example.challangeandroid.domain.GetSoundUseCase
import com.example.challangeandroid.domain.model.Sound
import com.example.challangeandroid.domain.model.toDomain
import com.highquality.base.data.Response
import com.highquality.base.exception.NoInternetException
import com.highquality.base.presenter.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class UsoundViewModel @Inject constructor(
    private val getSoundUseCase: GetSoundUseCase,
) : BaseViewModel() {

    private val mutableSound: MutableLiveData<List<Sound>> = MutableLiveData()
    val soundLiveData: LiveData<List<Sound>> = mutableSound

    /*private val isDbEmpty : MutableLiveData<Boolean> = MutableLiveData()
    val isDbEmptyLiveData: LiveData<Boolean> = isDbEmpty*/

    private val romList : MutableLiveData<List<Sound>> = MutableLiveData()
    val roomListLiveData: LiveData<List<Sound>> = romList



    fun fetchSounds() {
        viewModelScope.launch {
            notifyShowLoading()
            executeSimpleUseCase(getSoundUseCase).single().collect {
                notifyRemoveLoading()
                when (it) {
                    is Response.Success<List<Sound>> -> {
                        mutableSound.value = it.data!!
                        getSoundUseCase.insertSoundList(it.data.map { it.toDomain() })
                    }

                    is Response.Failure<Exception> -> {
                        when (it.error) {
                            is NoInternetException -> {
                                mutableConnection.value = false
                            }

                            else -> {
                                notifyError(it.error)
                            }

                        }
                    }

                }
            }
        }
    }



    fun getListFromRoom(){

        viewModelScope.launch {
            getSoundUseCase.getSoundsFromRoomDb().collect {
                romList.value = it
            }
        }
    }


}