package com.example.challangeandroid.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.challangeandroid.data.local.entity.SoundEntity


@Dao
interface SoundDao {

   @Query("SELECT * FROM sound_table ORDER BY id DESC")
    suspend fun getAllSounds(): List<SoundEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSounds(sounds: List<SoundEntity>)

}
