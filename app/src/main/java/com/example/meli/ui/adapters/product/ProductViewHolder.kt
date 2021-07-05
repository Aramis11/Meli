package com.example.meli.ui.adapters.product

import android.content.Context
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.meli.R
import com.example.meli.data.model.ProductModel
import com.example.meli.databinding.ItemProductBinding
import com.example.meli.ui.view.fragments.product.HomeSearchFragmentDirections
import com.example.meli.utils.Utils

class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemProductBinding.bind(view)

    fun bind(product: ProductModel) {

        binding.apply {
            tvProductName.text = product.productTitle
            tvPriceProduct.text = Utils().convertStringInCurrency(product.productPrice.toString())
            tvAvailableProduct.text = product.productAvailable.toString()
            ivProductImage.load(product.productImage) {
                crossfade(true)
                crossfade(1000)
            }
        }

        itemView.setOnClickListener { view ->
            val direction =
                HomeSearchFragmentDirections.actionHomeSearchFragmentToDetailFragment(product)
            view.findNavController().navigate(direction)
        }
    }
}