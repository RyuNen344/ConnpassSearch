package com.ryunen344.connpasssearch.feature.main.di

import com.ryunen344.connpasssearch.core.di.FragmentScope
import com.ryunen344.connpasssearch.feature.main.eventList.EventListFragment
import com.ryunen344.connpasssearch.feature.main.search.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [EventListFragmentModule::class])
    abstract fun contributeEventListFragment(): EventListFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeSearchFragment(): SearchFragment
}
