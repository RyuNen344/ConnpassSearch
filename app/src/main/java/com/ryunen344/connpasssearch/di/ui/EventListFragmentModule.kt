package com.ryunen344.connpasssearch.di.ui

import androidx.lifecycle.ViewModel
import com.ryunen344.connpasssearch.di.FragmentScope
import com.ryunen344.connpasssearch.di.viewmodel.ViewModelKey
import com.ryunen344.connpasssearch.main.EventListAdapter
import com.ryunen344.connpasssearch.main.eventList.EventListViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
internal abstract class EventListFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(EventListViewModel::class)
    @FragmentScope
    internal abstract fun bindEventListViewModel(viewModel: EventListViewModel): ViewModel

    @Module
    companion object {
        @JvmStatic
        @FragmentScope
        @Provides
        fun provideEventListAdapter(): EventListAdapter = EventListAdapter()
    }
}