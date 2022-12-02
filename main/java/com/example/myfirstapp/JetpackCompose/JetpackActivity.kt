package com.example.jetpackcomposeandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myfirstapp.R
import com.example.myfirstapp.databinding.ActivityJetpackBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityJetpackBinding
    //var counter = 0

    lateinit var mainViewMdoel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //setContentView(binding.root)

        mainViewMdoel = ViewModelProvider(this, MainViewModelFactory(10))[MainViewModel::class.java]
        binding.viewModel = mainViewMdoel

        binding.lifecycleOwner = this
    }
}