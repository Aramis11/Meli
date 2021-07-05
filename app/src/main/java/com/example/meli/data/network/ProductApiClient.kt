package com.example.meli.data.network

import com.example.meli.data.model.ProductResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url


interface ProductApiClient {
    @GET
    suspend fun getProducts(@Url url: String): Response<ProductResponseModel>
}