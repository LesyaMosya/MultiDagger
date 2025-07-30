package com.example.multidagger

import android.app.Application
import com.example.feature.HomeComponent
import com.example.feature.HomeComponentProvider

class App: Application(), HomeComponentProvider {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .baseUrl("https://www.flickr.com/services/rest/")
            .build()


    }

    override fun getHomeComponent(): HomeComponent {
        return appComponent
    }
}