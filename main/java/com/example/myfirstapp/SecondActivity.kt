package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    val tvResult :TextView
    get() = findViewById(R.id.tv_result)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        /*var name = intent.getStringExtra("NAME")
        var email = intent.getStringExtra("EMAIL")
        var age = intent.getIntExtra("AGE",0)*/

        var user = intent.getParcelableExtra<User>("USER")

    user?.let {
        tvResult.text = """
            name = ${user.name}
            email = ${user.email}
            age = ${user.age}
        """.trimIndent()
    }
    /* tvResult.text = """
            name = $name
            email = $email
            age = $age
        """.trimIndent()*/
    }
}