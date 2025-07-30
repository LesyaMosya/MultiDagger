package com.example.core

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Scope

@Module
class ApiModule {

    @AppScope
    @Provides
    fun provideRetrofit(@BaseUrl baseUrl: String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    @AppScope
    @Provides
    fun provideService(retrofit: Retrofit): Service =
        retrofit.create(Service::class.java)
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class BaseUrl