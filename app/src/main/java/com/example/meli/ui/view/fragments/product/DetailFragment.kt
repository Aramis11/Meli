package com.example.meli.ui.view.fragments.product

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.meli.R
import com.example.meli.data.model.ProductModel
import com.example.meli.databinding.FragmentDetailBinding
import com.example.meli.utils.Utils

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var binding: FragmentDetailBinding? = null
    private val mBinding get() = binding!!
    private val args: DetailFragmentArgs by navArgs()
    private lateinit var product: ProductModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        product = args.product
        showProduct()
    }

    @SuppressLint("SetTextI18n")
    private fun showProduct() {
        mBinding.apply {
            tvProductNameDetail.text = product.productTitle
            tvPriceProductDetail.text =
                Utils().convertStringInCurrency(product.productPrice.toString())
            tvAvailableProductDetail.text = product.productAvailable.toString()
            tvQuantityDetail.text =
                getString(R.string.title_installments) + " " + product.installments.quantity.toString()
            tvAmountDetail.text =
                getString(R.string.title_installments_values) + " " + Utils().convertFloatInCurrency(
                    product.installments.amount)
            tvStateProductDetail.text =
                product.addressSeller.productSellerState + " - " + product.addressSeller.productSellerCity
            ivProductDetailImage.load(product.productImage) {
                crossfade(true)
                crossfade(1000)
                placeholder(R.drawable.ic_placeholder)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}