package com.example.ritapp

import android.app.Application
import android.util.Log
import android.view.MenuItem
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ritapp.data.settings.SettingsPref
import com.example.ritapp.domain.model.Countries
import com.example.ritapp.domain.model.Dog
import com.example.ritapp.domain.usecase.GetDataDog
import com.example.ritapp.domain.usecase.GetDataNationality
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainViewModel(private val application: Application) : ViewModel() {
    val action: MutableLiveData<Action> = MutableLiveData()

    private val _dog = MutableLiveData<Dog>()
    val dog: LiveData<Dog> = _dog

    private val _countries = MutableLiveData<List<Countries>>()
    val countries: LiveData<List<Countries>> = _countries

    private val botNavPage: MutableLiveData<Int> = MutableLiveData()
    val botNavPageLive: LiveData<Int> = botNavPage

    var chekedApi: Int = 0
        set(value) {
            saveCurrentApi(value)
            field = value
        }
        get() = loadCurrentApi()

    var urlAPI: String = ""

    var names: String = ""

    @Inject
    lateinit var getDataDog: GetDataDog

    @Inject
    lateinit var getDataNationality: GetDataNationality

    val settingsPref = SettingsPref(application)

    init {
        (application as App).appComponent.inject(this)
    }

    fun loadDataDogJob() {
        viewModelScope.launch(Dispatchers.IO) {
            loadDataDog()
        }.start()
    }

    fun loadDataNatJob(names: List<String>) {
        viewModelScope.launch(Dispatchers.IO) {
            loadDataNat(names)
        }.start()
    }

    private suspend fun loadDataDog() = coroutineScope {
        launch {
            getDataDog().enqueue(object : Callback<Dog> {
                override fun onResponse(call: Call<Dog>, response: Response<Dog>) {
                    _dog.postValue(response.body())
                }

                override fun onFailure(call: Call<Dog>, t: Throwable) {
                    Log.d("myLogs", t.message.toString())
                }
            })
        }
    }

    //запрос с некскольми именами
    private suspend fun loadDataNat(names: List<String>) = coroutineScope {
        launch {
            getDataNationality(names).enqueue(object : Callback<List<Countries>> {
                override fun onResponse(
                    call: Call<List<Countries>>,
                    response: Response<List<Countries>>
                ) {
                    _countries.postValue(response.body())
                }

                override fun onFailure(call: Call<List<Countries>>, t: Throwable) {
                    Log.d("myLogs", t.message.toString())
                }

            })
        }
    }

    fun loadData(){
        when(chekedApi){
            0 -> loadDataDogJob()
            1-> {
                val namesList = names.filter { !it.isWhitespace() }.split(",").toList()
                if (namesList.size > 0)
                    loadDataNatJob(namesList)
            }
            2-> {}
        }
    }

    fun openImage() {
        action.value = Action.OpenImage
    }

    fun bottomNavItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.page_1 -> botNavPage.value = 1
            R.id.page_2 -> botNavPage.value = 2
        }

        return true
    }

    fun saveCurrentApi(index: Int) = settingsPref.saveCurrentApi(index)

    fun loadCurrentApi(): Int = settingsPref.loadCurrentApi()
}

enum class Action {
    Default, OpenImage,
}