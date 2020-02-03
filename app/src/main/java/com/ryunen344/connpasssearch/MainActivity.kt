package com.ryunen344.connpasssearch

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.ryunen344.connpasssearch.core.ui.LoggingInjectableActivity
import com.ryunen344.connpasssearch.databinding.ActivityMainBinding

class MainActivity : LoggingInjectableActivity() {

    private val navController: NavController by lazy { findNavController(R.id.nav_main) }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).also {
                it.lifecycleOwner = this@MainActivity
            }
    }

    override fun onBackPressed() {
        if (onBackPressedDispatcher.hasEnabledCallbacks()) {
        } else {
        }

        super.onBackPressed()
    }

    override fun onSupportNavigateUp() = navController.navigateUp()
}
