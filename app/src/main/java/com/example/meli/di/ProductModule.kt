package com.example.meli.di

import com.example.meli.data.network.ProductApiClient
import com.example.meli.utils.GlobalsVar
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductModule {
    @Provides
    @Singleton
    fun providerRetrofitInstance(): ProductApiClient = Retrofit.Builder()
        .baseUrl(GlobalsVar.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ProductApiClient::class.java)
}