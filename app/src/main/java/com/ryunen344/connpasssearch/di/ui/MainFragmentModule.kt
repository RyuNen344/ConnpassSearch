package com.ryunen344.connpasssearch.di.ui

import com.ryunen344.connpasssearch.di.FragmentScope
import com.ryunen344.connpasssearch.main.MainFragment
import com.ryunen344.connpasssearch.main.MainSectionsPagerAdapter
import com.ryunen344.connpasssearch.main.eventList.EventListFragment
import com.ryunen344.connpasssearch.main.search.SearchFragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class MainFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeEventListFragment(): EventListFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeSearchFragment(): SearchFragment

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideFragmentStateAdapter(mainFragment: MainFragment): MainSectionsPagerAdapter =
            MainSectionsPagerAdapter(mainFragment)
    }
}