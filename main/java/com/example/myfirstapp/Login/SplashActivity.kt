package com.example.androidp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfirstapp.Login.LoginActivity
import com.example.myfirstapp.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Thread(
            Runnable {
                kotlin.run {
                    try {
                        Thread.sleep(3000)

                        var intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)

                    }catch (e:Exception){
                        e.printStackTrace()
                    }
                }
            }
        ).start()
    }
}