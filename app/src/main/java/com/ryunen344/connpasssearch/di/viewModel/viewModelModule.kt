package com.ryunen344.connpasssearch.di.viewModel

import com.ryunen344.connpasssearch.main.eventList.EventListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { EventListViewModel(get()) }

}