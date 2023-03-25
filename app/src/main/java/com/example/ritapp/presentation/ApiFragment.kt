package com.example.ritapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.ritapp.*
import com.example.ritapp.databinding.FragmentMainBinding
import com.example.ritapp.di.UrlAPI

class ApiFragment : Fragment() {
    private val sharedViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMainBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.mainViewModel = sharedViewModel
        binding.lifecycleOwner = this

        val fragment: Fragment

        when (sharedViewModel.chekedApi) {
            0 -> {
                sharedViewModel.urlAPI = UrlAPI.DOG_API
                fragment = DogApiFragment()
                loadFragmentApi(fragment)
            }
            1 -> {
                sharedViewModel.urlAPI = UrlAPI.NAT_API
                fragment = NationalizeApiFragment()
                loadFragmentApi(fragment)
            }
            2 -> {
                sharedViewModel.urlAPI = UrlAPI.CUSTOM_API
                fragment = CustomApiFragment()
                loadFragmentApi(fragment)
            }
        }

        return binding.root
    }

    companion object {
        fun newInstance() = ApiFragment()
    }

    private fun loadFragmentApi(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container_api, fragment)
            .commit()
    }
}


