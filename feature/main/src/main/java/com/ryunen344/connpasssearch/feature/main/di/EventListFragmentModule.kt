package com.ryunen344.connpasssearch.feature.main.di

import androidx.lifecycle.ViewModel
import com.ryunen344.connpasssearch.core.di.FragmentScope
import com.ryunen344.connpasssearch.core.di.ViewModelKey
import com.ryunen344.connpasssearch.feature.main.eventList.EventListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class EventListFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(EventListViewModel::class)
    @FragmentScope
    internal abstract fun bindEventListViewModel(viewModel: EventListViewModel): ViewModel
}
