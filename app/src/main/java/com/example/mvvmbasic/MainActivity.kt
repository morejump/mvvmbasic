package com.example.mvvmbasic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import com.example.mvvmbasic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val KEY = "hellothere"
    }

    private lateinit var binding: ActivityMainBinding
    var viewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        viewModel.name.observe(this, Observer {
            Log.d("hellothere", it)
        })
        binding.textDisplay.setText("")
        binding.navigateButton.setOnClickListener {
            //            intent = Intent(this, SecondActivity::class.java)
//            intent.putExtra(KEY, "thao handsome")
//            startActivity(intent)
//            MyDialogFragment.createInstance().show(supportFragmentManager, "dialog")

        }
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.container, FragmentContainer()).commit()
    }

}
