package com.example.ritapp.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.ritapp.MainViewModel
import com.example.ritapp.R
import com.example.ritapp.di.UrlAPI

class SettingsFragment: Fragment() {
    private val sharedViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val radioGroup: RadioGroup = view.findViewById(R.id.radioGroupApi)
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val checkedRB = view.findViewById(checkedId) as RadioButton
            val checkedIndex = radioGroup.indexOfChild(checkedRB)
            sharedViewModel.chekedApi = checkedIndex
            Log.d("myLogs", "ID: $checkedId")
        }
        loadCurrentApi(radioGroup)

    }

    private fun loadCurrentApi(radioGroup: RadioGroup){
        for (i in 0 until radioGroup.childCount){
            val rb = radioGroup.getChildAt(i) as RadioButton
            rb.setText(UrlAPI.listAPI.get(i))
            if (radioGroup.indexOfChild(rb) == sharedViewModel.chekedApi)
                rb.isChecked = true
        }
    }
}