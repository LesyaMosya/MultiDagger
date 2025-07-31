package com.example.multidagger

import android.app.Application
import com.example.core.ApiModule
import com.example.core.AppScope
import com.example.core.BaseUrl
import com.example.core.ExtraUrl
import com.example.core.Service
import com.example.feature.di.HomeDependencies
import dagger.BindsInstance
import dagger.Component

@[AppScope Component(modules = [ApiModule::class])]
interface AppComponent: HomeDependencies {

    override fun getService(): Service

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun baseUrl(@BaseUrl baseUrl: String): Builder

        @BindsInstance
        fun extraUrl(@ExtraUrl extraUrl: String): Builder

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}