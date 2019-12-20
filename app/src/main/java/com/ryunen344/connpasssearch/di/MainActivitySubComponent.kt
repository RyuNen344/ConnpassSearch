package com.ryunen344.connpasssearch.di

import com.ryunen344.connpasssearch.main.MainActivity
import com.ryunen344.connpasssearch.main.MainFragment
import com.ryunen344.connpasssearch.main.eventList.EventListFragment
import com.ryunen344.connpasssearch.main.search.SearchFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent
interface MainActivitySubComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainActivity>

    fun inject(fragment : MainFragment)
    fun inject(eventListFragment: EventListFragment)
    fun inject(searchFragment: SearchFragment)
}