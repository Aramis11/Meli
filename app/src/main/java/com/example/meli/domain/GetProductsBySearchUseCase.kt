package com.example.meli.domain

import com.example.meli.data.model.ProductResponseModel
import com.example.meli.data.repository.DefaultProductRepository
import com.example.meli.data.repository.ProductRepository
import com.example.meli.utils.Resource
import retrofit2.Response
import javax.inject.Inject

class GetProductsBySearchUseCase
@Inject
constructor(
    private val repositoryDefault: DefaultProductRepository,
) {
    suspend operator fun invoke(productName: String): Resource<ProductResponseModel?> {
        return repositoryDefault.getAllProducts(product = productName)
    }
}