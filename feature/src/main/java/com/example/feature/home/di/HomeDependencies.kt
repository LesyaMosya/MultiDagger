package com.example.feature.home.di

import androidx.annotation.RestrictTo
import com.example.core.CoinGeckoService
import com.example.core.FlickrService
import kotlin.properties.Delegates.notNull

interface HomeDependencies {
    fun getFlickrService(): FlickrService
    fun getCoinGeckoService(): CoinGeckoService
}

interface HomeDependenciesProvider {

    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val dependencies: HomeDependencies

    companion object : HomeDependenciesProvider by HomeDependenciesStore
}

object HomeDependenciesStore : HomeDependenciesProvider {

    override var dependencies: HomeDependencies by notNull()
}


