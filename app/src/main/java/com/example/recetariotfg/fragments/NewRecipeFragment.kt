package com.example.recetariotfg.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.recetariotfg.R
import com.example.recetariotfg.Recipe
import com.google.firebase.firestore.FirebaseFirestore

class NewRecipeFragment : Fragment() {
    var userEmail : String = ""

    lateinit var etName : EditText
    lateinit var sType : Spinner
    lateinit var etIngredientes : EditText
    lateinit var etInstrucciones : EditText
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_new_recipe, container, false)

        etName = root.findViewById(R.id.etNombreReceta)
        sType = root.findViewById(R.id.spinnerTipoReceta)
        etIngredientes = root.findViewById(R.id.etIngredientes)
        etInstrucciones = root.findViewById(R.id.etInstrucciones)

        val btnPublicar : Button = root.findViewById(R.id.btnPublicarReceta)

        btnPublicar.setOnClickListener{
            findNavController().navigate(
                NewRecipeFragmentDirections.actionNewRecipeFragmentToHomeFragment()
            )
            addReceta()
        }


        return root
    }

    private fun addReceta() {
        val db = FirebaseFirestore.getInstance()
        val receta = Recipe(
            name = etName.text.toString(),
            type = sType.selectedItem.toString() ,
            ingred = etIngredientes.text.toString(),
            instructions = etInstrucciones.text.toString()
        )

        db.collection("Recipes").add(receta)
            .addOnSuccessListener { documentReference ->
                // Asigna el ID del documento recién creado a la receta
                receta.id = documentReference.id
                Log.d("Firestore", "Receta añadida con éxito: ${receta.name}")

                // Actualiza la receta con el ID
                db.collection("Recipes").document(receta.id!!).set(receta)
                    .addOnSuccessListener {
                        Log.d("Firestore", "Receta actualizada con ID: ${receta.id}")
                    }
                    .addOnFailureListener { e ->
                        Log.e("Firestore", "Error al actualizar receta con ID", e)
                    }
            }
            .addOnFailureListener { e ->
                Log.e("Firestore", "Error al añadir receta", e)
            }

    }

}