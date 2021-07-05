package com.example.meli.data.network

import com.example.meli.data.model.ProductResponseModel
import com.example.meli.data.repository.ProductRepository
import com.example.meli.utils.GlobalsVar.GET_PRODUCTS_BY_QUERY
import com.example.meli.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class ProductService
@Inject
constructor(
    private val productApiClient: ProductApiClient,
) : ProductRepository {

    override suspend fun searchProductByName(productName: String): Resource<ProductResponseModel?> {
        return try {
            withContext(Dispatchers.IO) {
                val response =
                    productApiClient.getProducts(url = productName)
                if (response.isSuccessful && response.body()?.product != null) {
                    response.body()?.let { products ->
                        return@let Resource.success(products)
                    } ?: Resource.error("Error inesperado, por favor intentalo más tarde", null)
                } else {
                    Resource.error("Error del servidor, por favor intentalo más tarde ", null)
                }
            }
        } catch (e: Exception) {
            Resource.error("Por favor verifica tu conexión a internet", null)
        }
    }
}