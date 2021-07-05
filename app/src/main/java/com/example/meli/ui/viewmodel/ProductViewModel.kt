package com.example.meli.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meli.data.model.ProductResponseModel
import com.example.meli.domain.GetProductsBySearchUseCase
import com.example.meli.utils.Resource
import com.example.meli.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel
@Inject
constructor(private var getAllProducts: GetProductsBySearchUseCase) : ViewModel() {

    val productModelList = MutableLiveData<ProductResponseModel>()
    val isLoadingProgressBar = MutableLiveData<Boolean>()
    val isErrorMessage = MutableLiveData<String>()

    fun onSearch(product: String) {
        viewModelScope.launch {
            isLoadingProgressBar.postValue(true)
            val result = getAllProducts(productName = product)
            if (result?.data != null) {
                isLoadingProgressBar.postValue(false)
                productModelList.postValue(result.data!!)
                isErrorMessage.postValue("")
            }else{
                isLoadingProgressBar.postValue(false)
                when(result?.status){
                    Status.ERROR -> {
                        isErrorMessage.postValue(result.message!!)
                    }
                }
            }
        }
    }
}