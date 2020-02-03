package com.ryunen344.connpasssearch.di

import com.ryunen344.connpasssearch.MainActivity
import com.ryunen344.connpasssearch.core.di.ActivityScope
import com.ryunen344.connpasssearch.feature.detail.DetailFragment
import com.ryunen344.connpasssearch.feature.detail.di.DetailFragmentModule
import com.ryunen344.connpasssearch.feature.main.MainFragment
import com.ryunen344.connpasssearch.feature.main.di.MainFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class MainActivityModule {


    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun contributeMainFragment(): MainFragment

    @ActivityScope
    @ContributesAndroidInjector(modules = [DetailFragmentModule::class])
    abstract fun contributeDetailFragment(): DetailFragment
}
