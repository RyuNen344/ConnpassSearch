package com.ryunen344.connpasssearch.di.ui

import androidx.lifecycle.ViewModel
import com.ryunen344.connpasssearch.detail.DetailFragment
import com.ryunen344.connpasssearch.di.scope.FragmentScope
import com.ryunen344.connpasssearch.di.viewmodel.ViewModelKey
import com.ryunen344.connpasssearch.detail.DetailViewModel
import com.ryunen344.connpasssearch.main.search.SearchFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class DetailFragmentModule {

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