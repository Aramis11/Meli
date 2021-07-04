package com.example.meli.data.repository

import com.example.meli.data.model.ProductResponseModel
import com.example.meli.data.network.ProductService

class ProductRepository {

    private val api = ProductService()

    suspend fun getAllProducts(): ProductResponseModel? {
        return api.getProducts()
    }

}