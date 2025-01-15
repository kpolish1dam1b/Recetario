package com.example.recetariotfg.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.recetariotfg.R

class NewRecipeFragment : Fragment() {

    val args : NewRecipeFragmentArgs by navArgs()
    var userEmail : String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_new_recipe, container, false)

        val btnPublicar : Button = root.findViewById(R.id.btnPublicarReceta)

        btnPublicar.setOnClickListener{
            findNavController().navigate(
                NewRecipeFragmentDirections.actionNewRecipeFragmentToRecipeFragment()
            )
        }


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userEmail = args.userEmail
        val tvUE = view.findViewById<TextView>(R.id.textViewUserEmail)
        tvUE.text = userEmail
    }

}