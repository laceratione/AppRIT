package com.example.ritapp.data.settings

import android.content.Context

class SettingsPref(context: Context) {
    private val namePref: String = "api"
    private val modePref: Int = Context.MODE_PRIVATE
    private val sharedPref = context.getSharedPreferences(namePref, modePref)

    fun saveCurrentApi(index: Int){
        sharedPref.edit().putInt("index", index).apply()
    }

    fun loadCurrentApi(): Int{
        return sharedPref.getInt("index", 0)
    }

}