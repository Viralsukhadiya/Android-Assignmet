package com.example.jetpackcomposeandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.myfirstapp.R
import com.example.myfirstapp.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {

    val tvName:TextView
        get() = findViewById(R.id.et_name)


    val tvEmail:TextView
        get() = findViewById(R.id.et_email)


    val tvAge:TextView
        get() = findViewById(R.id.et_age)

    val btnUpdate : Button
        get() = findViewById(R.id.btn_update)

    lateinit var binding: ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)
        //setContentView(R.layout.activity_data_binding)


        binding.person = Person("Viral","viral@gmail.com",5000)


        btnUpdate.setOnClickListener {
            binding.person = Person("Virals","viral@gmail1.com",500)

        }
    }
}