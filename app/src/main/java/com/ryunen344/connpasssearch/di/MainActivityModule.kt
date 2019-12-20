package com.ryunen344.connpasssearch.di

import com.ryunen344.connpasssearch.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(subcomponents = [MainActivitySubComponent::class])
abstract class MainActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivity() : MainActivity
}