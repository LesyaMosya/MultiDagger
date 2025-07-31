package com.example.feature.di

import com.example.core.Service

interface HomeDependencies {
    fun getService(): Service
}

interface HomeDependenciesProvider {
    fun getHomeDependencies(): HomeDependencies
}
