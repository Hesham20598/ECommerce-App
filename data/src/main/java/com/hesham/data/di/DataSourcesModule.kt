package com.hesham.data.di

import com.hesham.data.api.EcommerceServices
import com.hesham.data.dataSources.CategoriesOnlineDataSourceImpl
import com.hesham.data.dataSources.ProductsOnlineDataSourceImpl
import com.hesham.data.dataSources.SubCategoriesOnlineDataSourceImpl
import com.hesham.domain.repository.CategoriesOnlineDataSource
import com.hesham.domain.repository.NetworkHandler
import com.hesham.domain.repository.ProductsOnlineDataSource
import com.hesham.domain.repository.SubCategoryOnlineDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourcesModule {

    @Provides
    @Singleton
    fun provideCategoriesOnlineDataSource(services: EcommerceServices): CategoriesOnlineDataSource {
        return CategoriesOnlineDataSourceImpl(services)
    }

    @Provides
    @Singleton
    fun provideProductsOnlineDataSource(services: EcommerceServices): ProductsOnlineDataSource {
        return ProductsOnlineDataSourceImpl(services)
    }

    @Provides
    @Singleton
    fun provideSubCategoriesOnlineDataSource(services: EcommerceServices): SubCategoryOnlineDataSource {
        return SubCategoriesOnlineDataSourceImpl(services)
    }

    @Provides
    @Singleton
    fun provideNetworkHandler(): NetworkHandler {
        return object : NetworkHandler {
            override fun isOnline(): Boolean {
                return true
            }
        }
    }

}