package com.example.multidagger

import android.app.Application
import com.example.core.ApiModule
import com.example.core.AppScope
import com.example.core.CoinGeckoUrl
import com.example.core.FlickrUrl
import com.example.core.CoinGeckoService
import com.example.core.FlickrService
import com.example.feature.home.di.HomeDependencies
import dagger.BindsInstance
import dagger.Component

@[AppScope Component(modules = [ApiModule::class])]
interface AppComponent: HomeDependencies {

    override fun getFlickrService(): FlickrService
    override fun getCoinGeckoService(): CoinGeckoService

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun baseUrl(@FlickrUrl baseUrl: String): Builder

        @BindsInstance
        fun extraUrl(@CoinGeckoUrl extraUrl: String): Builder

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}