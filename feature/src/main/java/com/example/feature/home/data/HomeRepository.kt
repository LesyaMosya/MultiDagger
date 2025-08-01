package com.example.feature.home.data

import com.example.core.FlickrService
import com.example.core.CoinGeckoService
import com.example.feature.home.di.Feature
import javax.inject.Inject

@Feature
class HomeRepository @Inject constructor(
    private val flickrService: FlickrService,
    private val coinGeckoService: CoinGeckoService
) {
    suspend fun getImage(idImage: String) = flickrService.getFullSizeImage(idImage)

    suspend fun getCryptocurrency(id: String) = coinGeckoService.getCryptocurrencyByName(id)
}