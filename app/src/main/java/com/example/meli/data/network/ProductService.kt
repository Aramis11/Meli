package com.example.meli.data.network

import com.example.meli.core.RetrofitHelper
import com.example.meli.data.model.ProductResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getProducts(): ProductResponseModel? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ProductApiClient::class.java).getProducts()
            response.body()
        }
    }
}