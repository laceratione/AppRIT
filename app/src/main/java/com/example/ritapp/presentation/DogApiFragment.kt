package com.example.ritapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.ritapp.MainViewModel
import com.example.ritapp.R
import com.example.ritapp.databinding.FragmentDogApiBinding
import com.squareup.picasso.Picasso

class DogApiFragment: Fragment() {
    private val sharedViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDogApiBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_dog_api, container, false)
        binding.mainViewModel = sharedViewModel
        binding.lifecycleOwner = this

        sharedViewModel.dog.observe(requireActivity(), {
                Picasso.with(container?.context)
                .load(it.message)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.ivDog)
        })

        return binding.root
    }

    companion object {
        fun newInstance() = DogApiFragment()
    }
}