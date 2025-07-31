package com.example.feature.domain

import com.example.feature.data.HomeRepository
import javax.inject.Inject

class GetImageUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(idImage: String) = repository.getImage(idImage)
}