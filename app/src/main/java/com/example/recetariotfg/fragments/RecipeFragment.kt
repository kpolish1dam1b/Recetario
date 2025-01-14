package com.example.recetariotfg.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.recetariotfg.R

class RecipeFragment : Fragment() {
    val args: RecipeFragmentArgs by navArgs()
    var titReceta : String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        titReceta = args.tituloReceta
        val tvReceta = view.findViewById<TextView>(R.id.tvTitleReceta)
        tvReceta.text = titReceta
    }
}