package com.example.meli.data.repository

import com.example.meli.data.model.ProductResponseModel
import com.example.meli.data.network.ProductService
import com.example.meli.utils.Resource
import javax.inject.Inject

class DefaultProductRepository
@Inject
constructor(
    private val apiService: ProductService
) {
    suspend fun getAllProducts(product: String): Resource<ProductResponseModel?> {
        return apiService.searchProductByName(productName = product)
    }
}