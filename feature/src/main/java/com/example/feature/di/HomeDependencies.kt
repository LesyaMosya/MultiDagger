package com.example.feature.di

import androidx.annotation.RestrictTo
import com.example.core.NewService
import com.example.core.Service
import kotlin.properties.Delegates.notNull

interface HomeDependencies {
    fun getService(): Service
    fun getNewService(): NewService
}

interface HomeDependenciesProvider {

    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val dependencies: HomeDependencies

    companion object : HomeDependenciesProvider by HomeDependenciesStore
}

object HomeDependenciesStore : HomeDependenciesProvider {

    override var dependencies: HomeDependencies by notNull()
}


