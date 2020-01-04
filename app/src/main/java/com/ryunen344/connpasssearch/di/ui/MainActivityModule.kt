package com.ryunen344.connpasssearch.di.ui

import com.ryunen344.connpasssearch.detail.DetailFragment
import com.ryunen344.connpasssearch.di.scope.ActivityScope
import com.ryunen344.connpasssearch.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class MainActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun contributeMainFragment(): MainFragment

    @ActivityScope
    @ContributesAndroidInjector(modules = [DetailFragmentModule::class])
    abstract fun contributeDetailFragment(): DetailFragment
}