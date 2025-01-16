package com.example.recetariotfg.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.recetariotfg.R
import com.google.firebase.Firebase
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SignUpFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_sign_up, container, false)

        val btnLogin = root.findViewById<Button>(R.id.tvLogin)
        val btnSignup = root.findViewById<Button>(R.id.btnSignUp)
        val editTextEmail = root.findViewById<EditText>(R.id.editTextEmail)
        val editTextPassword = root.findViewById<EditText>(R.id.editTextPassword)

        btnLogin.setOnClickListener {
            findNavController().navigate(
                SignUpFragmentDirections.actionSignUpFragmentToLoginFragment()
            )
        }

        btnSignup.setOnClickListener {
                if (editTextEmail.text.isNotEmpty() && editTextPassword.text.isNotEmpty()){
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(editTextEmail.text.toString(),
                        editTextPassword.text.toString()).addOnCompleteListener{
                            if (it.isSuccessful){
                                findNavController().navigate(
                                    SignUpFragmentDirections.actionSignUpFragmentToHomeFragment()
                                )
                            } else {
                                showAlertDialog("Se ha producido un error al crear un nuevo usuario.")
                            }
                    }
                } else {showAlertDialog("No se han rellenado todos los campos")}
        }

        return root
    }

    private fun showAlertDialog(message: String) {
        val builder = AlertDialog.Builder(this.context)
        builder.setTitle("Alert")
        builder.setMessage(message)

        // Set positive button
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss() // Dismiss the dialog when the user clicks OK
        }

        // Set negative button (optional)
        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }

        // Create and show the alert dialog
        val dialog = builder.create()
        dialog.show()
    }

}
