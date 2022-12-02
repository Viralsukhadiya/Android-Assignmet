package com.example.androidp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.example.myfirstapp.R
import com.example.myfirstapp.databinding.ActivitySignUpBinding
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener{

            var name = binding.etName.text.toString()
            var contact = binding.etContact.text.toString()
            var email = binding.etEmail.text.toString()
            var password = binding.etPassword.text.toString()
            var cpassword = binding.etCPassword.text.toString()

            resetError()

            if (name.isEmpty()){
                //error name
                // binding.etName.error = "Enter User name"
                showError(binding.etName,"Enter User name")
            }else if (!isValidContact(contact)) {
                //binding.etContact.error = "Enter valid contact"
                showError(binding.etContact,"Enter valid contact")
            }else if (!isValidEmail(email)){
                //binding.etEmail.error = "Enter valid email"
                showError(binding.etEmail,"Enter valid email")
            }else if (!isValidPassword(password)){
                //binding.etPassword.error = "Enter valid password"
                showError(binding.etPassword,"Enter valid password")
            }else if (cpassword != password){
                //binding.etCPassword.error = "Password mismatch"
                showError(binding.etCPassword,"Password mismatch")
                binding.etCPassword.setText("")
            }else{
                //all form vlideted
                Toast.makeText(this, "All fields are validated", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun resetError(){
        binding.etName.setBackgroundResource(R.drawable.et_background)
        binding.etCPassword.setBackgroundResource(R.drawable.et_background)
        binding.etPassword.setBackgroundResource(R.drawable.et_background)
        binding.etContact.setBackgroundResource(R.drawable.et_background)
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
    private fun isValidContact(contact: String): Boolean {
        return contact.length == 10
    }

}