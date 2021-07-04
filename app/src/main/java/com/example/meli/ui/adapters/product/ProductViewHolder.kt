package com.example.meli.ui.adapters.product

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.meli.data.model.ProductModel
import com.example.meli.databinding.ItemProductBinding
import com.squareup.picasso.Picasso

class ProductViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemProductBinding.bind(view)

    fun bind(product: ProductModel){
        binding.tvProductName.text = product.productTitle
        binding.tvPriceProduct.text = product.productPrice.toString()
        binding.tvConditionProduct.text = product.productCondition
        Picasso.get().load(product.productImage).into(binding.ivProductImage)
    }
}