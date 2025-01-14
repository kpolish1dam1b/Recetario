package com.example.recetariotfg.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.recetariotfg.R
import com.google.firebase.Firebase
import com.google.firebase.analytics.analytics
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_login, container, false)

        val btnLogin : Button = root.findViewById(R.id.loginBtn)
        val btnSignup : Button = root.findViewById(R.id.btnSignup)
        val editTextEmail = root.findViewById<EditText>(R.id.emailEditText)
        val editTextPassword = root.findViewById<EditText>(R.id.passwordEditText)


        btnLogin.setOnClickListener {
            onBtnLoginClick()
            if (editTextEmail.text.isNotEmpty() && editTextPassword.text.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(editTextEmail.text.toString(),
                    editTextPassword.text.toString()).addOnCompleteListener{
                    if (it.isSuccessful){
                        findNavController().navigate(
                            LoginFragmentDirections.actionLoginFragmentToHomeFragment(ejemplo = editTextEmail.text.toString())
                        )
                    } else {
                        showAlertDialog("Se ha producido un error al iniciar sesión")
                    }
                }
            } else {showAlertDialog("No se han rellenado todos los campos")}

        }

        btnSignup.setOnClickListener{
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToSignUpFragment()
            )
        }

        return root
    }

    fun onBtnLoginClick(){
        Firebase.analytics.logEvent("log_btn_click", null)
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