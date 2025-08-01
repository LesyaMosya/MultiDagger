package com.example.feature.home.domain

import com.example.feature.home.data.HomeRepository
import javax.inject.Inject

class GetCryptocurrencyUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(id: String) = repository.getCryptocurrency(id)
}