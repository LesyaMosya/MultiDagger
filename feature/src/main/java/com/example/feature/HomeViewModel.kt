package com.example.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.core.Service
import dagger.internal.Provider
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val service: Service
): ViewModel() {

    class Factory @Inject constructor(
        private val service: Provider<Service>
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == HomeViewModel::class.java)
            return HomeViewModel(service.get()) as T
        }
    }
}