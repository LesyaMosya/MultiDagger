package com.example.multidagger

import android.app.Application
import com.example.core.ApiModule
import com.example.core.AppScope
import com.example.core.BaseUrl
import com.example.feature.HomeComponent
import com.example.feature.HomeFragment
import dagger.BindsInstance
import dagger.Component

@[AppScope Component(modules = [ApiModule::class])]
interface AppComponent: HomeComponent {

    override fun inject(home: HomeFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun baseUrl(@BaseUrl baseUrl: String): Builder

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}