package com.example.meli.data.network

import com.example.meli.data.model.ProductResponseModel
import retrofit2.Response
import retrofit2.http.GET


interface ProductApiClient {

    @GET("/sites/MCO/search?q=Iphone8")
    suspend fun getProducts(): Response<ProductResponseModel>

}