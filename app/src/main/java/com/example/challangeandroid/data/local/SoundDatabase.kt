package com.example.challangeandroid.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.challangeandroid.data.local.dao.SoundDao
import com.example.challangeandroid.data.local.entity.SoundEntity


@Database(entities = [SoundEntity::class], version = 1)
abstract class SoundDatabase : RoomDatabase() {

    abstract fun getSoundDao(): SoundDao

}
