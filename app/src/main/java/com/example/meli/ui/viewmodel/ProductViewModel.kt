package com.example.meli.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meli.data.model.ProductResponseModel
import com.example.meli.domain.GetProductsBySearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel
@Inject
constructor(private var getAllProducts: GetProductsBySearchUseCase) : ViewModel() {

    val productModelList = MutableLiveData<ProductResponseModel>()
    val isLoadingProgressBar = MutableLiveData<Boolean>()

    fun onSearch(product: String) {
        viewModelScope.launch {
            isLoadingProgressBar.postValue(true)
            val result = getAllProducts(product = product)
            if (!result?.product.isNullOrEmpty()) {
                isLoadingProgressBar.postValue(false)
                productModelList.postValue(result!!)
            }else{
                isLoadingProgressBar.postValue(false)
            }
        }
    }
}