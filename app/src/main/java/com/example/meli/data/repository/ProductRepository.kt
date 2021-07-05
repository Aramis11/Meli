package com.example.meli.data.repository

import com.example.meli.data.model.ProductResponseModel
import com.example.meli.utils.Resource

interface ProductRepository {

    suspend fun searchProductByName(productName: String): Resource<ProductResponseModel?>
}