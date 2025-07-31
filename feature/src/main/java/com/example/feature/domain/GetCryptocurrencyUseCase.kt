package com.example.feature.domain

import com.example.feature.data.HomeRepository
import javax.inject.Inject

class GetCryptocurrencyUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(id: String) = repository.getCryptocurrency(id)
}