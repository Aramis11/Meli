package com.example.meli.ui.viewmodel

import com.example.meli.domain.GetProductsBySearchUseCase
import com.example.meli.utils.Status
import org.junit.Before
import org.junit.Test
import javax.inject.Inject
import com.google.common.truth.Truth.assertThat


class ProductViewModelTest @Inject constructor(var getAllProducts: GetProductsBySearchUseCase) {

    private lateinit var viewModel: ProductViewModel
    private val PRODUCT_NAME = "Iphone"

    @Before
    fun setup() {
        viewModel = ProductViewModel(getAllProducts)
    }

    @Test
    suspend fun consultAnyProductByName() {
        viewModel.onSearch(PRODUCT_NAME)
        val result = getAllProducts(PRODUCT_NAME)
        assertThat(result.status).isEqualTo(Status.SUCCESS)


    }

}