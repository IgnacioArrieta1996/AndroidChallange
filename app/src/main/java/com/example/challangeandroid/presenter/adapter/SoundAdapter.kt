package com.example.challangeandroid.presenter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.challangeandroid.R
import com.example.challangeandroid.domain.model.Sound

class SoundAdapter(
    private val soundList: List<Sound>,
    private val onClickListener: (Sound) -> Unit
) :
    RecyclerView.Adapter<SoundViewHolder>() {

    lateinit var context: Context
    var soundListFilter = ArrayList<Sound>()

    init {
        soundListFilter = soundList as ArrayList<Sound>
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundViewHolder {
        context = parent.context

        val layoutInflater = LayoutInflater.from(parent.context)

        return SoundViewHolder(layoutInflater.inflate(R.layout.item_sound, parent, false))

    }

    override fun onBindViewHolder(holder: SoundViewHolder, position: Int) {
        val item = soundListFilter[position]

        val animation: Animation = AnimationUtils.loadAnimation(context, R.anim.animation_one)
        holder.bind(item, onClickListener)
        holder.itemView.startAnimation(animation)

    }

    override fun getItemCount(): Int = soundListFilter.size

    override fun getItemViewType(position: Int): Int {
        return position
    }


}

