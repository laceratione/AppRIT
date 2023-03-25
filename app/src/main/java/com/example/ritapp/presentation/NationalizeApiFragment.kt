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
import com.example.ritapp.databinding.FragmentNationalizeApiBinding

class NationalizeApiFragment: Fragment() {
    private val sharedViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentNationalizeApiBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_nationalize_api, container, false)
        binding.mainViewModel = sharedViewModel
        binding.lifecycleOwner = this

        return binding.root
    }

}