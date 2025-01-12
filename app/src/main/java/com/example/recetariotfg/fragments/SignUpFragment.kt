package com.example.recetariotfg.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.recetariotfg.R

class SignUpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_sign_up, container, false)

        val btnLogin = root.findViewById<Button>(R.id.tvLogin)
        val btnSignup = root.findViewById<TextView>(R.id.btnSignUp)

        btnLogin.setOnClickListener {
            findNavController().navigate(
                SignUpFragmentDirections.actionSignUpFragmentToLoginFragment()
            )
        }

        btnSignup.setOnClickListener{
            findNavController().navigate(
                SignUpFragmentDirections.actionSignUpFragmentToHomeFragment(ejemplo = "signed up")
            )
        }

        return root
    }

}