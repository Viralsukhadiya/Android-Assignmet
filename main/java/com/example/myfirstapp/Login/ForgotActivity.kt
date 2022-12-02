package com.example.androidp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.myfirstapp.R
import com.example.myfirstapp.databinding.ActivityForgotBinding

class ForgotActivity : AppCompatActivity() {

    lateinit var binding: ActivityForgotBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityForgotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {

            var number = binding.etNumber.text.toString()
            resetError()

            if (!isValidNumber(number)){

                showError(binding.etNumber,"Enter valid contact")
            }

        }
    }

    private fun resetError(){

        binding.etNumber.setBackgroundResource(R.drawable.et_background)

    }

    private fun showError(editText: EditText, message: String) {
        editText.setBackgroundResource(R.drawable.et_background_error)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


    private fun isValidNumber(number: String): Boolean {
        return number.length == 10
    }
}