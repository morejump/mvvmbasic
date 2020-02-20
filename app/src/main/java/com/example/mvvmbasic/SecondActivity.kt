package com.example.mvvmbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mvvmbasic.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        val text = intent.getStringExtra(MainActivity.KEY)
        binding.displayMe.text = text
    }
}
