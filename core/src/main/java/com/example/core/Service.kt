package com.example.core

import com.example.core.model.CryptocurrencyWithDescription
import com.example.core.model.SizesResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface FlickrService {

    @GET("?method=flickr.photos.getSizes&api_key=da9d38d3dee82ec8dda8bb0763bf5d9c&format=json&nojsoncallback=1")
    suspend fun getFullSizeImage(
        @Query("photo_id") idImage: String
    ): SizesResponse
}

interface CoinGeckoService {

    @Headers("x-cg-demo-api-key: CG-QS9uxxeV2SPizHgzQC3Y8tyK")
    @GET("coins/{id}")
    suspend fun getCryptocurrencyByName(
        @Path("id") id: String
    ): CryptocurrencyWithDescription
}