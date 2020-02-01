package com.ryunen344.connpasssearch.feature.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.ryunen344.connpasssearch.core.ui.LoggingInjectableActivity
import com.ryunen344.connpasssearch.feature.main.databinding.ActivityMainBinding
import dagger.android.AndroidInjection

class MainActivity : LoggingInjectableActivity() {

    companion object {
        private const val REQUEST_CODE = 1
    }

    private val navController: NavController by lazy { findNavController(R.id.nav_main) }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this@MainActivity

//        supportFragmentManager.commit {
//            replace(R.id.main_fragment_container, MainFragment())
//        }
    }

    override fun onBackPressed() {
        if (onBackPressedDispatcher.hasEnabledCallbacks()) {
        } else {
        }

        super.onBackPressed()
    }

    override fun onSupportNavigateUp() = navController.navigateUp()

}
