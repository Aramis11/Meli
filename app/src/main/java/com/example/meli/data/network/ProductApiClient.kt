package com.example.meli.data.network

import com.example.meli.data.model.ProductResponseModel
import com.example.meli.utils.GlobalsVar.GET_PRODUCTS_BY_QUERY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url


interface ProductApiClient {
    @GET(GET_PRODUCTS_BY_QUERY)
    suspend fun getProducts(
        @Query("q") url: String
    ): Response<ProductResponseModel>
}