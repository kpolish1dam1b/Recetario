package com.example.recetariotfg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")

        // Leer los datos una vez
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Obtener el valor de la base de datos
                val value = dataSnapshot.getValue(String::class.java)
                Log.d("Firebase", "Valor: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Manejar errores
                Log.w("Firebase", "Error al leer datos.", error.toException())
            }
        })
    }
}