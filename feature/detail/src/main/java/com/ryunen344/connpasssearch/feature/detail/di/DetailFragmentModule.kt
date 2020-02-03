package com.ryunen344.connpasssearch.feature.detail.di

import androidx.lifecycle.ViewModel
import com.ryunen344.connpasssearch.core.di.ViewModelKey
import com.ryunen344.connpasssearch.feature.detail.DetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class DetailFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    internal abstract fun bindDetailViewModel(viewModel: DetailViewModel): ViewModel

//    @Module
//    companion object {
//        @JvmStatic
//        @FragmentScope
//        @Provides
//        fun provideEventListAdapter(): EventListAdapter = EventListAdapter()
//    }
}
