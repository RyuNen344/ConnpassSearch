package com.ryunen344.connpasssearch.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.ryunen344.connpasssearch.BaseActivity
import com.ryunen344.connpasssearch.R
import com.ryunen344.connpasssearch.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : BaseActivity(), HasAndroidInjector {

    companion object {
        private const val REQUEST_CODE = 1
    }

    private val navController: NavController by lazy { findNavController(R.id.nav_main) }

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this@MainActivity

//        supportFragmentManager.commit {
//            replace(R.id.main_fragment_container, MainFragment())
//        }
    }

    override fun onSupportNavigateUp() = navController.navigateUp()

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}