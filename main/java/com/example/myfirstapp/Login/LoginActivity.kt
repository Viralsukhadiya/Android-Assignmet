package com.example.androidp.activities

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.example.myfirstapp.R
import com.example.myfirstapp.databinding.ActivityLoginBinding
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSigup.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
        binding.btnForgot.setOnClickListener {
            startActivity(Intent(this, ForgotActivity::class.java))
        }
        binding.btnLogin.setOnClickListener {

            var email = binding.etEmail.text.toString()

            var password = binding.etPassword.text.toString()

            resetError()

            if (!isValidEmail(email)) {
                showError(binding.etEmail, "Enter valid email")
            } else if (!isValidPassword(password)) {
                //binding.etPassword.error = "Enter valid password"
                showError(binding.etPassword, "Enter valid password")
            } else {
                //all form vlideted
                Toast.makeText(this, "All fields are validated", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun resetError() {
        binding.etPassword.setBackgroundResource(R.drawable.et_background)
        binding.etEmail.setBackgroundResource(R.drawable.et_background)
    }

    private fun showError(editText: EditText, message: String) {
        editText.setBackgroundResource(R.drawable.et_background_error)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun isValidPassword(password: String): Boolean {

        // Regex to check valid password.
        val regex = ("^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,16}$")

        return Pattern.compile(regex).matcher(password).matches()
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
