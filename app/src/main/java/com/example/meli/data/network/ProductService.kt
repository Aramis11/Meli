package com.example.meli.data.network

import com.example.meli.core.RetrofitHelper
import com.example.meli.data.model.ProductResponseModel
import com.example.meli.utils.GlobalsVar.GET_PRODUCTS_BY_QUERY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getProducts(product: String): ProductResponseModel? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ProductApiClient::class.java)
                .getProducts(url = GET_PRODUCTS_BY_QUERY + product)
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }

        }
    }
}