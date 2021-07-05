package com.example.meli.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

import com.google.gson.annotations.SerializedName
import java.net.Inet4Address

@Parcelize
data class ProductModel(

    @SerializedName("id") val productId: String,
    @SerializedName("site_id") val productSiteId: String,
    @SerializedName("title") val productTitle: String,
    @SerializedName("price") val productPrice: Int,
    @SerializedName("available_quantity") val productAvailable: Int,
    @SerializedName("thumbnail") val productImage: String,

    //Information to display in the product detail
    //Installments
    @SerializedName("installments") val installments: Installments,

    //Address Seller
    @SerializedName("address") val addressSeller: AddressSeller,
) : Parcelable


@Parcelize
data class Installments(
    @SerializedName("quantity") val quantity: Int,
    @SerializedName("amount") val amount: Float,
) : Parcelable

@Parcelize
data class AddressSeller(
    @SerializedName("state_name") val productSellerState: String,
    @SerializedName("city_name") val productSellerCity: String,
) : Parcelable
