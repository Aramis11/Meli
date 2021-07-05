package com.example.meli.ui.view.fragments.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meli.R
import com.example.meli.data.model.ProductModel
import com.example.meli.databinding.FragmentHomeBinding
import com.example.meli.ui.adapters.product.ProductAdapter
import com.example.meli.ui.viewmodel.ProductViewModel
import com.example.meli.utils.Utils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeSearchFragment : Fragment(R.layout.fragment_home), SearchView.OnQueryTextListener {

    private var binding: FragmentHomeBinding? = null
    private val mBinding get() = binding!!
    private lateinit var adapter: ProductAdapter
    private var productList = mutableListOf<ProductModel>()
    private val productViewModel: ProductViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.svSearchViewProduct.setOnQueryTextListener(this)
        initRecyclerView()
        responseProductListObserver()
    }

    private fun responseProductListObserver() {
        productViewModel.productModelList.observe(requireActivity(), { product ->
            productList.clear()
            productList.addAll(product.product)
            adapter.notifyDataSetChanged()
        })
    }

    private fun loadProductsBySearch(query: String) {
        productViewModel.onSearch(product = query)
        mBinding.svSearchViewProduct.clearFocus()
        Utils().hideKeyboard(requireActivity())
    }

    private fun initRecyclerView() {
        adapter = ProductAdapter(productList)
        mBinding.rvSearchProduct.layoutManager = LinearLayoutManager(requireContext())
        mBinding.rvSearchProduct.adapter = adapter

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()) {
            query?.let { product ->
                loadProductsBySearch(query = product)
            }
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}