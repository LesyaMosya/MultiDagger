package com.example.feature.di

import androidx.lifecycle.ViewModel
import com.example.feature.presentation.HomeFragment
import dagger.Component
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class Feature

@[Feature Component(dependencies = [HomeDependencies::class])]
interface HomeComponent {
    fun inject(fragment: HomeFragment)

    @Component.Builder
    interface Builder {

        fun dependencies(homeDependencies: HomeDependencies): Builder

        fun build(): HomeComponent
    }
}

internal class HomeComponentViewModel : ViewModel() {
    val newDetailsComponent =
        DaggerHomeComponent
            .builder()
            .dependencies(HomeDependenciesProvider.dependencies)
            .build()
}
