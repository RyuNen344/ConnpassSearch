package com.ryunen344.connpasssearch.di.ui

import com.ryunen344.connpasssearch.di.FragmentScope
import com.ryunen344.connpasssearch.main.MainFragment
import com.ryunen344.connpasssearch.main.MainFragmentStateAdapter
import com.ryunen344.connpasssearch.main.eventList.EventListFragment
import com.ryunen344.connpasssearch.main.search.SearchFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

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