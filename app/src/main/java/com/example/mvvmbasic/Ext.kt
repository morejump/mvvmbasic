package com.example.mvvmbasic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

typealias Navigator = MutableLiveData<Unit>

fun Navigator.call() {
    this.value = value
}