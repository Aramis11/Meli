package com.example.meli.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meli.data.model.ProductModel
import com.example.meli.databinding.ActivityMainBinding
import com.example.meli.ui.adapters.product.ProductAdapter
import com.example.meli.ui.viewmodel.ProductViewModel
import com.example.meli.utils.Utils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ProductAdapter
    private var productList = mutableListOf<ProductModel>()
    private val productViewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.svSearchViewProduct.setOnQueryTextListener(this)
        initRecyclerView()
        responseProductListObserver()
    }

    private fun responseProductListObserver() {
        productViewModel.productModelList.observe(this, { product ->
            productList.clear()
            productList.addAll(product.product)
            adapter.notifyDataSetChanged()
        })
    }

    private fun loadProductsBySearch(query: String) {
        productViewModel.onSearch(product = query)
        binding.svSearchViewProduct.clearFocus()
        Utils().hideKeyboard(this)
    }

    private fun initRecyclerView() {
        adapter = ProductAdapter(productList)
        binding.rvSearchProduct.layoutManager = LinearLayoutManager(this)
        binding.rvSearchProduct.adapter = adapter

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