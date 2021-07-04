package com.example.meli.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meli.data.model.ProductModel
import com.example.meli.databinding.ActivityMainBinding
import com.example.meli.ui.adapters.product.ProductAdapter
import com.example.meli.ui.viewmodel.ProductViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ProductAdapter
    private var productList = mutableListOf<ProductModel>()
    private val productViewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        loadProducts()

    }

    private fun loadProducts() {
        productViewModel.onCreate()
        productViewModel.productModelList.observe(this, { product ->
            productList.clear()
            productList.addAll(product.product)
            adapter.notifyDataSetChanged()
        })
    }

    private fun initRecyclerView() {
        adapter = ProductAdapter(productList)
        binding.rvSearchProduct.layoutManager = LinearLayoutManager(this)
        binding.rvSearchProduct.adapter = adapter
    }
}