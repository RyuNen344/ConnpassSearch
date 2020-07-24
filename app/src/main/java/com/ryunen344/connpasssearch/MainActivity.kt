package com.ryunen344.connpasssearch

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.ryunen344.connpasssearch.core.ui.LoggingLifecycleActivity
import com.ryunen344.connpasssearch.databinding.ActivityMainBinding

class MainActivity : LoggingLifecycleActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).also {
            it.lifecycleOwner = this@MainActivity
        }

        navController =
            (supportFragmentManager.findFragmentById(R.id.nav_main) as NavHostFragment).navController
    }

    override fun onBackPressed() {
        if (onBackPressedDispatcher.hasEnabledCallbacks()) {
        } else {
        }

        super.onBackPressed()
    }

    override fun onSupportNavigateUp() = navController.navigateUp()
}
