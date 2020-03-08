package com.example.mvvmbasic

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

typealias Navigator = MutableLiveData<Unit>

fun Navigator.call() {
    this.value = value
}
@BindingAdapter("currency")
fun TextView.setCurrency(text: String) {
    this.text = text + "$"
}