package com.example.mvvmbasic

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import java.util.*
import kotlin.concurrent.schedule

class MainViewModel(application: Application) : AndroidViewModel(application) {
    var display = MutableLiveData<String>()
    lateinit var persons: LiveData<List<Person>>
    private lateinit var appDatabase: AppDatabase

    init {
        display.value = "hahhahahaahah"
        appDatabase = AppDatabase.getInstance(application)
        persons = appDatabase.personDao().all
    }

    fun changeData() {
        appDatabase.personDao().insertPerson(Person())
    }

}