package com.ryunen344.connpasssearch.di;

import com.ryunen344.connpasssearch.initializer.AppInitializer
import com.ryunen344.connpasssearch.initializer.AppInjector
import com.ryunen344.connpasssearch.initializer.CoilInitializer
import com.ryunen344.connpasssearch.initializer.TimberInitializer
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module
abstract class AppModuleBinds {
    @Binds
    @IntoSet
    abstract fun provideAppInjector(bind: AppInjector): AppInitializer

    @Binds
    @IntoSet
    abstract fun provideCoilInitializer(bind: CoilInitializer): AppInitializer

    @Binds
    @IntoSet
    abstract fun provideTimberInitializer(bind: TimberInitializer): AppInitializer
}
