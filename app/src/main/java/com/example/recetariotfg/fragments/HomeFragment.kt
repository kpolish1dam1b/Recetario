package com.example.recetariotfg.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.recetariotfg.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment() {

    val args : HomeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val btnAdd = root.findViewById<FloatingActionButton>(R.id.fab)

        btnAdd.setOnClickListener{
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToNewRecipeFragment()
            )
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ejemplo: String? = args.ejemplo
        val tvEjemplo = view.findViewById<TextView>(R.id.tvEjemplo)
        tvEjemplo.text = ejemplo
    }

}