package com.ryunen344.connpasssearch.di.ui

import com.ryunen344.connpasssearch.core.di.FragmentScope
import com.ryunen344.connpasssearch.feature.main.eventList.EventListFragment
import com.ryunen344.connpasssearch.feature.main.search.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class MainFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [EventListFragmentModule::class])
    abstract fun contributeEventListFragment(): EventListFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeSearchFragment(): SearchFragment

    //fixme:なぜCompanion ObjectでProviderを記載するとエラーになるのか調べる
//    @Module
//    companion object {
//        @JvmStatic
//        @Provides
//        fun provideMainFragmentStateAdapter(fragment: MainFragment) : MainFragmentStateAdapter {
//            return MainFragmentStateAdapter(fragment)
//        }
//    }
}
