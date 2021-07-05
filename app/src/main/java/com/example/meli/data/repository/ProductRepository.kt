package com.example.meli.data.repository

import com.example.meli.data.model.ProductResponseModel
import com.example.meli.data.network.ProductService
import javax.inject.Inject

class ProductRepository
@Inject
constructor(private val apiService: ProductService) {
    suspend fun getAllProducts(product: String): ProductResponseModel? {
        return apiService.getProducts(product = product)
    }
}