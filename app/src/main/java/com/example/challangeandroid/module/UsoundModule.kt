package com.example.challangeandroid.module


import android.content.Context
import androidx.room.Room
import com.example.challangeandroid.data.UsoundRepository
import com.example.challangeandroid.data.local.SoundDatabase
import com.example.challangeandroid.data.network.api.UsoundApi
import com.example.challangeandroid.domain.GetSoundUseCase
import com.example.challangeandroid.domain.repository.IGetSoundListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class UsoundModule {

    @Provides
    fun provideUsoundApi(retrofit: Retrofit) = retrofit.create(UsoundApi::class.java)

    @Provides
    fun provideGetSoundUseCase(repository: IGetSoundListRepository) = GetSoundUseCase(repository)

}

@Module
@InstallIn(SingletonComponent::class)
abstract class UsoundViewModelData {

    @Binds
    abstract fun bindIGetSoundListRepository(repo: UsoundRepository): IGetSoundListRepository



}










