package com.example.mvvmbasic

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.concurrent.schedule

class MainViewModel : ViewModel() {
    var count = 1
    var display = "first"
    var name = MutableLiveData<String>()

    init {
        count = 2
        display = "second"
        name.value= "hahhahahaahah"
        Timer().schedule(4000){
            name.postValue("last value")
        }
    }

    fun changeData() {
        display = "lol"
    }

}