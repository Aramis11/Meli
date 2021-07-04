package com.example.meli.data.model

import com.google.gson.annotations.SerializedName

data class ResponseModel(

    @SerializedName("site_id") val siteId: String,
    @SerializedName("query") val query: String,
    @SerializedName("paging") val paging: Paging,
    @SerializedName("results") val product: MutableList<ProductModel>,

    )

data class Paging(

    @SerializedName("total") val total: Int,
    @SerializedName("primary_results") val primaryResults: Int,
    @SerializedName("offset") val offset: Int,
    @SerializedName("limit") val limit: Int,

    )