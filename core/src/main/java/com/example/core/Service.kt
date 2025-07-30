package com.example.core

import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("?method=flickr.photos.getSizes&api_key=da9d38d3dee82ec8dda8bb0763bf5d9c&format=json&nojsoncallback=1")
    suspend fun getFullSizeImage(
        @Query("photo_id") idImage: String
    ): SizesResponse
}