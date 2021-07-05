package com.example.meli.domain

import com.example.meli.data.model.ProductResponseModel
import com.example.meli.data.repository.ProductRepository
import javax.inject.Inject

class GetProductsBySearchUseCase
@Inject
constructor(private val repository: ProductRepository) {
    suspend operator fun invoke(product: String): ProductResponseModel? =
        repository.getAllProducts(product = product)
}