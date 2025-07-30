package com.example.feature

interface HomeComponent {
    fun inject(home: HomeFragment)
}

interface HomeComponentProvider {
    fun getHomeComponent(): HomeComponent
}