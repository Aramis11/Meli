package com.example.meli.domain

import com.example.meli.data.model.ProductResponseModel
import com.example.meli.data.repository.ProductRepository

class GetProductsBySearchUseCase {

    private val repository = ProductRepository()

    suspend operator fun invoke(): ProductResponseModel? = repository.getAllProducts()
}