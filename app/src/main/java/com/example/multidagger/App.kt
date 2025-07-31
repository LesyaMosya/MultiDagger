package com.example.multidagger

import android.app.Application
import com.example.feature.di.HomeDependencies
import com.example.feature.di.HomeDependenciesProvider

class App: Application(), HomeDependenciesProvider {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .baseUrl("https://www.flickr.com/services/rest/")
            .extraUrl("https://api.coingecko.com/api/v3/")
            .build()


    }

    override fun getHomeDependencies(): HomeDependencies {
        return appComponent
    }

}