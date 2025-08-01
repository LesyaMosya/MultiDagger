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
    @FlickrServer
    fun provideRetrofit(@FlickrUrl baseUrl: String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    @AppScope
    @Provides
    fun provideService(@FlickrServer retrofit: Retrofit): FlickrService =
        retrofit.create(FlickrService::class.java)

    @AppScope
    @Provides
    @CoinGeckoServer
    fun provideNewRetrofit(@CoinGeckoUrl baseUrl: String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    @AppScope
    @Provides
    fun provideNewService(@CoinGeckoServer retrofit: Retrofit): CoinGeckoService =
        retrofit.create(CoinGeckoService::class.java)
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class FlickrUrl

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class FlickrServer

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class CoinGeckoServer

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class CoinGeckoUrl