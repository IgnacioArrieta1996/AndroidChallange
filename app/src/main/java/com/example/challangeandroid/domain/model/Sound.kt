package com.example.challangeandroid.domain.model

import android.os.Parcelable
import com.example.challangeandroid.data.local.entity.SoundEntity
import com.example.challangeandroid.data.network.response.SoundResponse
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sound(
    val id: Int = 0,
    val type: String = "",
    val ancActivated: Boolean = false,
    val frequency: Int = 0,
    val channel: String = "",
    val hearingThresholdDifference: Double = 0.0,
    val avgSoundPressureLevelDifference: Double = 0.0,
    val instantSoundPressureLevelDifference: Double = 0.0,
    val avgDistanceDifference: Double = 0.0,
    val freqInstantIntensityDifference: Double = 0.0,
    val freqAvgIntensityDifference: Double = 0.0,
    val lastUpdate: String = "",
    val timestamp: String = "",
    val patient: Int = 0

) : Parcelable

fun SoundResponse.toDomain() = Sound(
    id,
    type,
    ancActivated,
    frequency,
    channel,
    hearingThresholdDifference,
    avgSoundPressureLevelDifference,
    instantSoundPressureLevelDifference,
    avgDistanceDifference,
    freqInstantIntensityDifference,
    freqAvgIntensityDifference,
    lastUpdate,
    timestamp,
    patient
)

fun SoundEntity.toDomain() = Sound(
    id,
    type,
    ancActivated,
    frequency,
    channel,
    hearingThresholdDifference,
    avgSoundPressureLevelDifference,
    instantSoundPressureLevelDifference,
    avgDistanceDifference,
    freqInstantIntensityDifference,
    freqAvgIntensityDifference,
    lastUpdate,
    timestamp,
    patient
)

fun Sound.toDomain() = SoundEntity(
    id,
    type,
    ancActivated,
    frequency,
    channel,
    hearingThresholdDifference,
    avgSoundPressureLevelDifference,
    instantSoundPressureLevelDifference,
    avgDistanceDifference,
    freqInstantIntensityDifference,
    freqAvgIntensityDifference,
    lastUpdate,
    timestamp,
    patient
)
