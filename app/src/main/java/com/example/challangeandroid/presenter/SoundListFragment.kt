package com.example.challangeandroid.presenter

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.androidchallenge.presenter.adapter.SoundAdapter
import com.example.challangeandroid.presenter.viewmodel.UsoundViewModel
import com.example.challangeandroid.R
import com.example.challangeandroid.databinding.FragmentSoundListBinding
import com.example.challangeandroid.domain.model.Sound
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SoundListFragment : Fragment(R.layout.fragment_sound_list) {


    private lateinit var binding: FragmentSoundListBinding
    private val viewModel: UsoundViewModel by viewModels()
    private lateinit var adapter: SoundAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSoundListBinding.bind(view)
        adapter = SoundAdapter(mutableListOf()) { sound ->
            onItemSelected(sound)
        }

        viewModel.getListFromRoom()
        setupObserversViewModel()
        bindData()

    }

    private fun initRecycler(soundList: List<Sound>) {
        adapter = SoundAdapter(soundList) { sound -> onItemSelected(sound) }
        binding.soundListFragmentRecyclerListSound.adapter = adapter
        AnimationUtils.loadAnimation(requireContext(), R.anim.animation_three)
    }

    fun setupObserversViewModel() {
        viewModel.mutableLoading.observe(viewLifecycleOwner, Observer {
            Log.d("mylogs", "loading status: ${it}")
            if (it) {
                binding.mainContainer.visibility = View.GONE
                binding.layoutLoading.root.visibility = View.VISIBLE
            } else {
                binding.mainContainer.visibility = View.VISIBLE
                binding.layoutLoading.root.visibility = View.GONE
            }
        })
        viewModel.mutableConnection.observe(viewLifecycleOwner, Observer {
            showNoConnection(it)
            Log.d("mylogs", "connection: ${it}")
        })
        viewModel.mutableThrowables.observe(viewLifecycleOwner, Observer {
            showGenericError(it != null)
            Log.d("mylogs", "generic error: ${it}")
        })
        viewModel.soundLiveData.observe(viewLifecycleOwner, { list ->
            initRecycler(list)
            Log.d("mylogs", "livedata: ${list}")
        })

        viewModel.roomListLiveData.observe(viewLifecycleOwner, Observer {
            if (it.isNullOrEmpty()){

            } else{
                initRecycler(it)
            }
            Log.d("roomlista", it.toString())
        })
    }

    private fun showNoConnection(value: Boolean) {
        if (value) {
            binding.layoutNoConnection.container.visibility = View.GONE
            binding.mainContainer.visibility = View.VISIBLE
        } else {
            Toast.makeText(requireContext(), "No internet connection", Toast.LENGTH_SHORT).show()
            binding.layoutNoConnection.container.visibility = View.VISIBLE
            binding.mainContainer.visibility = View.GONE
        }
    }

    private fun showGenericError(value: Boolean) {
        if (value) {
            binding.layoutGenericError.root.visibility = View.VISIBLE
            binding.mainContainer.visibility = View.GONE
        } else {
            binding.layoutGenericError.root.visibility = View.GONE
            binding.mainContainer.visibility = View.VISIBLE
        }
    }

    private fun bindData() {
        binding.layoutGenericError.textviewTry.setOnClickListener {
            viewModel.fetchSounds()
        }
        binding.layoutNoConnection.textviewTry.setOnClickListener {
            viewModel.fetchSounds()
        }

    }

    private fun onItemSelected(sound: Sound) {
        val action =
            SoundListFragmentDirections.actionSoundListFragmentToSoundDetailsFragment(sound)
        findNavController().navigate(action)
    }

    private fun fetchData(){
        viewModel.fetchSounds()
        setupObserversViewModel()
    }


}
