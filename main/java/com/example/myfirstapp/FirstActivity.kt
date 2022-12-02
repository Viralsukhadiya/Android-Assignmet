package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class FirstActivity : AppCompatActivity() {

    lateinit var btnSubmil : Button

    val etName :EditText
    get() = findViewById(R.id.et_name)

    val etEmail : EditText
    get() = findViewById(R.id.et_emeil)

    val etAge : EditText
    get() = findViewById(R.id.et_Age)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_acvitity)

        //object initialize here
        btnSubmil = findViewById(R.id.btn_submit)

        //button Click event
        btnSubmil.setOnClickListener {
            //read value from edittext
            var name = etName.text.toString().trim()
            var email = etEmail.text.toString().trim()
            var age = if (etAge.text.toString().isEmpty()) 0 else etAge.text.toString().trim().toInt()

            var user =  User(name,email,age)

            //ot navigate from FirstActivity to SecondActivity
            var intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("USER", user)
           /* intent.putExtra("NAME",name)
            intent.putExtra("EMAIL",email)
            intent.putExtra("AGE",age)*/
            startActivity(intent)

            //Toast.makeText(this,"Button Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}