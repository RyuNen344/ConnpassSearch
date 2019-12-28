package com.ryunen344.connpasssearch.di

import com.ryunen344.connpasssearch.di.ui.MainActivityModule
import com.ryunen344.connpasssearch.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun contributeMainActivity(): MainActivity
}