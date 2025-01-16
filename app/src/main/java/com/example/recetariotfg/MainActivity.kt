package com.example.recetariotfg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import com.example.recetariotfg.databinding.ActivityMainBinding
import com.example.recetariotfg.fragments.FavsFragment
import com.example.recetariotfg.fragments.HomeFragment
import com.example.recetariotfg.fragments.NewRecipeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.menu.setOnItemSelectedListener {
            when (it.itemId){
                R.id.item_home -> replaceFragment(HomeFragment())
                R.id.item_favs -> replaceFragment(FavsFragment())
                R.id.item_new -> replaceFragment(NewRecipeFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment)
        fragmentTransaction.commit()

        fragmentManager.executePendingTransactions()
    }
}