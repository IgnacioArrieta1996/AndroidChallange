package com.example.challangeandroid.data.network.response

import com.google.gson.annotations.SerializedName

data class SoundResponse(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("type")
    val type: String = "",
    @SerializedName("anc_activated")
    val ancActivated: Boolean = false,
    @SerializedName("frequency")
    val frequency: Int = 0,
    @SerializedName("channel")
    val channel: String = "",
    @SerializedName("hearing_threshold_difference")
    val hearingThresholdDifference: Double = 0.0,
    @SerializedName("avg_sound_pressure_level_difference")
    val avgSoundPressureLevelDifference: Double = 0.0,
    @SerializedName("instant_sound_pressure_level_difference")
    val instantSoundPressureLevelDifference: Double = 0.0,
    @SerializedName("avg_distance_difference")
    val avgDistanceDifference: Double = 0.0,
    @SerializedName("freq_instant_intensity_difference")
    val freqInstantIntensityDifference: Double = 0.0,
    @SerializedName("freq_avg_intensity_difference")
    val freqAvgIntensityDifference: Double = 0.0,
    @SerializedName("last_update")
    val lastUpdate: String = "",
    @SerializedName("timestamp")
    val timestamp: String = "",
    @SerializedName("patient")
    val patient: Int = 0

)

