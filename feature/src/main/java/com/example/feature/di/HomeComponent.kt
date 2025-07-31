package com.example.feature.di

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

        fun dependencies(homDeps: HomeDependencies): Builder

        fun build(): HomeComponent
    }
}

interface HomeComponentProvider {
    fun getHomeComponent(): HomeComponent
}
