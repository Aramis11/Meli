package com.example.meli.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meli.data.model.ProductResponseModel
import com.example.meli.domain.GetProductsBySearchUseCase
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    val productModelList = MutableLiveData<ProductResponseModel>()

    //Use Case
    var getAllProducts = GetProductsBySearchUseCase()

    fun onCreate() {
        viewModelScope.launch {
            val result = getAllProducts()
            if(!result?.product.isNullOrEmpty()){
                productModelList.postValue(result!!)
            }
        }
    }
}