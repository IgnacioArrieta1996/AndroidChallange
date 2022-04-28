package com.example.challangeandroid.presenter.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.challangeandroid.data.network.response.SoundResponse
import com.example.challangeandroid.databinding.ItemSoundBinding
import com.example.challangeandroid.domain.model.Sound


class SoundViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSoundBinding.bind(view)

    fun bind(sound: Sound, onClickListener: (Sound) -> Unit) {

        binding.itemSoundTxtType.text = sound.type
        itemView.setOnClickListener { onClickListener(sound) }

    }

}