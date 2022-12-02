package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.androidp.activities.LoginActivity
import com.example.movielist.RecyclerActivity
import com.example.myfirstapp.fragments.FragmentsMainActivity

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    lateinit var btnlinearlayout : Button
    lateinit var btnrelativelayout: Button
    lateinit var btnfragment : Button
    lateinit var btnlogin: Button
    lateinit var btnrecycler:Button
    lateinit var btnviewpager:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnlinearlayout = findViewById(R.id.btn_linear_layout)
        btnrelativelayout = findViewById(R.id.btn_relative_layout)
        btnfragment = findViewById(R.id.btn_fragment)
        btnlogin = findViewById(R.id.btn_login)
        btnrecycler = findViewById(R.id.btn_recycler)
        btnviewpager = findViewById(R.id.btn_viewpager)


        btnlinearlayout.setOnClickListener {

            var linear = btnlinearlayout

            var intent = Intent(this,FirstActivity::class.java)
            startActivity(intent)

        }

        btnrelativelayout.setOnClickListener {

            var retative = btnrelativelayout

            var intent = Intent(this,RelativeMainActivity::class.java)
            startActivity(intent)
        }

        btnfragment.setOnClickListener {
            var fragment = btnfragment

            var intent = Intent(this, FragmentsMainActivity::class.java)
            startActivity(intent)
        }
        btnlogin.setOnClickListener {
            var login = btnlogin

            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        btnrecycler.setOnClickListener {
            var recycler = btnrecycler

            var intent = Intent(this, RecyclerActivity::class.java)
            startActivity(intent)
        }
        btnviewpager.setOnClickListener {
            var viewpager = btnviewpager

            var intent = Intent(this, RecyclerActivity::class.java)
            startActivity(intent)
        }
    }


}