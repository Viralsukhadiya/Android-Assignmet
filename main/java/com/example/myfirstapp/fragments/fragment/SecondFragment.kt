package com.example.myfirstapp.fragments.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myfirstapp.R


class SecondFragment : Fragment() {

    lateinit var tvResult: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvResult = view.findViewById(R.id.tv_result)

        arguments?.let {
            var name = it.getString("NAME")
            var email = it.getString("EMAIL")
            var age = it.getString("AGE")

            tvResult.text = """
                name : $name
                email : $email
                age : $age
            """.trimIndent()
        }
    }

}