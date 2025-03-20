package com.example.inventory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Safely retrieve NavController from the NavHostFragment
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as? NavHostFragment

        if (navHostFragment != null) {
            navController = navHostFragment.navController
            // Set up the action bar for use with the NavController
            NavigationUI.setupActionBarWithNavController(this, navController)
        } else {
            // Handle case when NavHostFragment is not found
            // You can log a message, show a toast, or handle accordingly
            // For now, we will just throw an error (this is for debugging purposes)
            throw IllegalStateException("NavHostFragment not found in the layout.")
        }
    }

    /**
     * Handle navigation when the user chooses Up from the action bar.
     */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
