package com.example.recetariotfg.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.recetariotfg.R
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference

class NewRecipeFragment : Fragment() {

    val args : NewRecipeFragmentArgs by navArgs()
    var userEmail : String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_new_recipe, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userEmail = args.userEmail
        val tvUE = view.findViewById<TextView>(R.id.textViewUserEmail)
        tvUE.text = userEmail
    }

}