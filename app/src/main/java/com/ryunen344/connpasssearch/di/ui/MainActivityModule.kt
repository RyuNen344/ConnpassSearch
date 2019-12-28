package com.ryunen344.connpasssearch.di.ui

import com.ryunen344.connpasssearch.di.ActivityScope
import com.ryunen344.connpasssearch.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class MainActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun contributeMainFragment(): MainFragment
}