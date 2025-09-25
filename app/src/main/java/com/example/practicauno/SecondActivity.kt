package com.example.practicauno

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.practicauno.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Habilitamos la flecha de "Atrás" en la barra de acción
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Referenciamos las vistas usando sus nuevos IDs
        val navView: BottomNavigationView = binding.navViewSecond
        val navController = findNavController(R.id.nav_host_fragment_activity_second)

        // Configuramos la barra con los dos nuevos destinos
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_list, R.id.navigation_info
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    // Esta función maneja el clic en la flecha de "Atrás" de la barra de acción
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}