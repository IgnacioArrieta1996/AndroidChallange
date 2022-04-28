package com.example.challangeandroid.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sound_table")
data class SoundEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,

    @ColumnInfo(name = "type") val type: String = "",
    @ColumnInfo(name = "anc_activated") val ancActivated: Boolean = false,
    @ColumnInfo(name = "frequency") val frequency: Int = 0,
    @ColumnInfo(name = "channel") val channel: String = "",
    @ColumnInfo(name = "hearing_threshold_difference") val hearingThresholdDifference: Double = 0.0,
    @ColumnInfo(name = "avg_sound_pressure_level_difference") val avgSoundPressureLevelDifference: Double = 0.0,
    @ColumnInfo(name = "instant_sound_pressure_level_difference") val instantSoundPressureLevelDifference: Double = 0.0,
    @ColumnInfo(name = "avg_distance_difference") val avgDistanceDifference: Double = 0.0,
    @ColumnInfo(name = "freq_instant_intensity_difference") val freqInstantIntensityDifference: Double = 0.0,
    @ColumnInfo(name = "freq_avg_intensity_difference") val freqAvgIntensityDifference: Double = 0.0,
    @ColumnInfo(name = "last_update") val lastUpdate: String = "",
    @ColumnInfo(name = "timestamp") val timestamp: String = "",
    @ColumnInfo(name = "patient") val patient: Int = 0

)
