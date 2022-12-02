package com.example.myfirstapp.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.myfirstapp.R
import com.example.myfirstapp.fragments.fragment.FirstFragment

class FragmentsMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments_main)

        var fragment = FirstFragment()

        //add first fragment to the container
        var manager : FragmentManager = supportFragmentManager
        var transaction : FragmentTransaction = manager.beginTransaction()
        transaction.add(R.id.fragment_container,fragment)
        transaction.commit()
    }
}