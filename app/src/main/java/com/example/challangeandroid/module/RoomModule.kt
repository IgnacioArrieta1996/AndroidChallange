package com.example.challangeandroid.module

import android.content.Context
import androidx.room.Room
import com.example.challangeandroid.data.local.SoundDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val SOUND_DATABASE_NAME = "sound_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, SoundDatabase::class.java, SOUND_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideSoundDao(database: SoundDatabase) = database.getSoundDao()

}



