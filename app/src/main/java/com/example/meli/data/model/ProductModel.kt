package com.example.meli.data.model

import com.google.gson.annotations.SerializedName

data class ProductModel(

    @SerializedName("id") val productId: Int,
    @SerializedName("site_id") val productSiteId: String,
    @SerializedName("title") val productTitle: String,
    @SerializedName("price") val productPrice: Int,
    @SerializedName("condition") val productCondition: String,
    @SerializedName("thumbnail") val productImage: String,

    //Information to display in the product detail
    //Installments

    @SerializedName("quantity") val productInstallment: Int,
    @SerializedName("amount") val productInstallmentAmount: Float,

    //Address

    @SerializedName("state_name") val productSellerState: String,
    @SerializedName("city_name") val productSellerCity: String,

    )
