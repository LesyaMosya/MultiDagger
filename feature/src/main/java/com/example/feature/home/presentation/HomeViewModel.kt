package com.example.feature.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.core.model.CryptocurrencyWithDescription
import com.example.core.model.Size
import com.example.feature.home.domain.GetCryptocurrencyUseCase
import com.example.feature.home.domain.GetImageUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch
import javax.inject.Provider

class HomeViewModel(
    private val imageId: String,
    private val cryptId: String,
    private val getImageUseCase: GetImageUseCase,
    private val getCryptocurrencyUseCase: GetCryptocurrencyUseCase
) : ViewModel() {

    init {
        fetchUser()
    }

    private val _image = MutableLiveData<Size>()
    val image: LiveData<Size> get() = _image

    private val _cryptocurrency = MutableLiveData<CryptocurrencyWithDescription>()
    val cryptocurrency: LiveData<CryptocurrencyWithDescription> get() = _cryptocurrency

    fun fetchUser() {
        viewModelScope.launch {
            _image.value = getImageUseCase(imageId).sizes.size[0]
            _cryptocurrency.value = getCryptocurrencyUseCase(cryptId)
        }
    }

    class Factory @AssistedInject constructor(
        @Assisted("imageId") private val imageId: String,
        @Assisted("cryptId") private val cryptId: String,
        private val getImageUseCase: Provider<GetImageUseCase>,
        private val getCryptocurrencyUseCase: Provider<GetCryptocurrencyUseCase>
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == HomeViewModel::class.java)
            return HomeViewModel(
                imageId,
                cryptId,
                getImageUseCase.get(),
                getCryptocurrencyUseCase.get()
            ) as T
        }

        @AssistedFactory
        interface Factory {
            fun create(
                @Assisted("imageId") imageId: String,
                @Assisted("cryptId") cryptId: String
            ): HomeViewModel.Factory
        }
    }
}