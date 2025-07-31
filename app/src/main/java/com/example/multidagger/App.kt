package com.example.multidagger

import android.app.Application
import com.example.feature.di.HomeDependenciesStore

class App: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .baseUrl("https://www.flickr.com/services/rest/")
            .extraUrl("https://api.coingecko.com/api/v3/")
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        HomeDependenciesStore.dependencies = appComponent
    }

}