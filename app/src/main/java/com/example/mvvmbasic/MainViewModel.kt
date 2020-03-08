package com.example.mvvmbasic

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*
import kotlin.concurrent.schedule

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val thao = "vi thao dep trai"
    var display = MutableLiveData<String>()

    private val appDatabase: AppDatabase by lazy {
        AppDatabase.getInstance(application)
    }

    init {
        display.value = "hahhahahaahah"

    }

    fun changeData() {
    }

}