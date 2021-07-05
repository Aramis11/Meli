package com.example.meli.data.network

import com.example.meli.data.model.ProductResponseModel
import com.example.meli.utils.GlobalsVar.GET_PRODUCTS_BY_QUERY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductService
@Inject constructor(private val productApiClient: ProductApiClient) {
    suspend fun getProducts(product: String): ProductResponseModel? {
        return withContext(Dispatchers.IO) {
            val response = productApiClient.getProducts(url = GET_PRODUCTS_BY_QUERY + product)
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }

        }
    }
}