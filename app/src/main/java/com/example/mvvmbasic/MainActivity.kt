package com.example.mvvmbasic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmbasic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val KEY = "hellothere"
    }

    private lateinit var binding: ActivityMainBinding

    val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        viewModel.display.observe(this, Observer {
            Log.d("hellothere", it)
        })
        viewModel.persons.observe(this, Observer {
            Log.d("hellothere", "inside person: ${it.size}")
        })
        binding.textDisplay.setText("")
    }

}
