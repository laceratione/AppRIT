package com.example.ritapp.presentation.mainactivity

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ritapp.*
import com.example.ritapp.databinding.ActivityMainBinding
import com.example.ritapp.domain.model.Countries
import com.example.ritapp.presentation.ApiFragment
import com.example.ritapp.presentation.ImageFragment
import com.example.ritapp.presentation.SettingsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        val mainViewModel = ViewModelProvider(this, MainViewModelFactory(application)).get(
            MainViewModel::class.java)
        binding.mainViewModel = mainViewModel
        binding.lifecycleOwner = this

        loadFragment(ApiFragment.newInstance())

        mainViewModel.action.observe(this, {
            when (it) {
                Action.OpenImage -> {
                    val url: String? = mainViewModel.dog.value?.message
                    url?.let {
                        val fragment = ImageFragment(it)
                        loadFragment(fragment)
                    }
                }
            }
        })

        mainViewModel.botNavPageLive.observe(this, {
            val fragment: Fragment
            when(it){
                1 -> {
                    fragment = ApiFragment()
                    loadFragment(fragment)
                }
                2 -> {
                    fragment = SettingsFragment()
                    loadFragment(fragment)
                }
            }
        })

        mainViewModel.countries.observe(this, {
            var message: String = ""
            for(item in it.countries){
                message += "Страна: ${item.countryId}, вероятность: ${item.probability} \n"
            }
            buildDialog(message).show()
        })

        mainViewModel.countriesMultiple.observe(this, {
            val tmp: List<Countries> = it

            var message: String = ""
            for(item in it){
                message += "-----${item.name}----- \n"
                for(elem in item.countries){
                    message += "Страна: ${elem.countryId}, вероятность: ${elem.probability} \n"
                }
            }
            buildDialog(message).show()
        })
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun buildDialog(message: String): Dialog {
        val view = layoutInflater.inflate(R.layout.custom_alert_dialog, null)
        val textView: TextView = view.findViewById(R.id.message)
        textView.setText(message)

        val alertDialog = AlertDialog.Builder(this)
        alertDialog
            .setTitle("Результаты запроса")
            .setView(view)
            .setPositiveButton("OK", object: DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, id: Int) {
                    dialog?.cancel()
                }

            })
        return alertDialog.create()
    }
}