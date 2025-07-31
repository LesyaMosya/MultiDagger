package com.example.feature.data

import com.example.core.NewService
import com.example.core.Service
import com.example.feature.di.Feature
import javax.inject.Inject

@Feature
class HomeRepository @Inject constructor(
    private val service: Service,
    private val newService: NewService
) {
    suspend fun getImage(idImage: String) = service.getFullSizeImage(idImage)

    suspend fun getCryptocurrency(id: String) = newService.getCryptocurrencyByName(id)
}