package com.example.myfirstapp.fragments.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.myfirstapp.R


class FirstFragment : Fragment() {

    lateinit var btnNext:Button
    lateinit var etName :EditText
    lateinit var etEmail:EditText
    lateinit var etAge:EditText


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etName = view.findViewById(R.id.et_name)
        etEmail = view.findViewById(R.id.et_emeil)
        etAge = view.findViewById(R.id.et_age)
        btnNext = view.findViewById(R.id.btn_next)

        btnNext.setOnClickListener {
            var name = etName.text.toString().trim()
            var email = etEmail.text.toString().trim()
            var age:Int = etAge.text.toString().trim().toInt()

            var bundle = Bundle()
            bundle.putString("NAME", name)
            bundle.putString("EMAIL", email)
            bundle.putInt("AGE", age)

            // navigate to second fragment
            var fragment = SecondFragment()
            fragment.arguments = bundle
            // add first fragment to the container
            var manager: FragmentManager = requireActivity().supportFragmentManager
            var transaction: FragmentTransaction = manager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}
