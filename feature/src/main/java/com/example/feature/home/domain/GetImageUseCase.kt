package com.example.feature.home.domain

import com.example.feature.home.data.HomeRepository
import javax.inject.Inject

class GetImageUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(idImage: String) = repository.getImage(idImage)
}