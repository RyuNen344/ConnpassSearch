package com.ryunen344.connpasssearch.di.viewModel

import com.ryunen344.connpasssearch.detail.DetailViewModel
import com.ryunen344.connpasssearch.main.eventList.EventListViewModel
import com.ryunen344.connpasssearch.main.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {
    viewModel { EventListViewModel(get()) }
    viewModel { SearchViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}