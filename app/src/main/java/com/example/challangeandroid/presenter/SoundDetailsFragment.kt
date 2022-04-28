package com.example.challangeandroid.presenter


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.navigation.fragment.navArgs
import com.androidchallenge.presenter.adapter.SoundAdapter
import com.example.challangeandroid.R
import com.example.challangeandroid.databinding.FragmentSoundDetailsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SoundDetailsFragment : Fragment(R.layout.fragment_sound_details) {

    private lateinit var binding: FragmentSoundDetailsBinding
    private val navArgs: SoundDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSoundDetailsBinding.bind(view)
        setUpData()

    }


    private fun setUpData() {

        binding.itemSoundDetailsTxtType.text = navArgs.sound.type
        binding.itemSoundDetailsTxtId.text = "ID: ${navArgs.sound.id.toString()}"
        binding.itemSoundDetailsTxtAncActivated.text =
            "Anc activated: ${navArgs.sound.ancActivated.toString()}"
        binding.itemSoundDetailsTxtFrequency.text =
            "Frequency: ${navArgs.sound.frequency.toString()}"
        binding.itemSoundDetailsTxtChannel.text =
            "Channel: ${navArgs.sound.channel.toString()}"
        binding.itemSoundDetailsTxtHearThreDiff.text =
            "Hearing threshold difference: ${navArgs.sound.hearingThresholdDifference.toString()}"
        binding.itemSoundDetailsTxtAvgSoundPressure.text =
            "AVG sound pressure level difference: ${navArgs.sound.avgSoundPressureLevelDifference.toString()}"
        binding.itemSoundDetailsTxtInstantSoundPressure.text =
            "Instant sound pressure level difference: ${navArgs.sound.instantSoundPressureLevelDifference.toString()}"
        binding.itemSoundDetailsTxtAvgDistanceDifference.text =
            "AVG distance difference: ${navArgs.sound.avgDistanceDifference.toString()}"
        binding.itemSoundDetailsTxtFreqInstantIntensity.text =
            "Freq instant intensity difference: ${navArgs.sound.freqInstantIntensityDifference.toString()}"
        binding.itemSoundDetailsTxtFreqAvgIntensityDiff.text =
            "Freq AVG intensity difference: ${navArgs.sound.freqAvgIntensityDifference.toString()}"
        binding.itemSoundDetailsTxtLastUpdate.text =
            "Last update: ${navArgs.sound.lastUpdate.toString()}"
        binding.itemSoundDetailsTxtTimestamp.text =
            "TimeStamp: ${navArgs.sound.timestamp.toString()}"
        binding.itemSoundDetailsTxtPatient.text =
            "Patient: ${navArgs.sound.patient.toString()}"

    }


}
