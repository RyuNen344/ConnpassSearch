package com.ryunen344.connpasssearch.feature.main.di

import com.ryunen344.connpasssearch.core.di.FragmentScope
import com.ryunen344.connpasssearch.feature.main.MainFragment
import com.ryunen344.connpasssearch.feature.main.MainFragmentStateAdapter
import com.ryunen344.connpasssearch.feature.main.eventList.EventListFragment
import com.ryunen344.connpasssearch.feature.main.search.SearchFragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module(includes = [MainFragmentModule.Providers::class])
abstract class MainFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [EventListFragmentModule::class])
    abstract fun contributeEventListFragment(): EventListFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeSearchFragment(): SearchFragment

    @Module
    internal object Providers {
        @Provides
        internal fun provideMainFragmentStateAdapter(mainFragment: MainFragment) =
            MainFragmentStateAdapter(mainFragment)
    }
}
