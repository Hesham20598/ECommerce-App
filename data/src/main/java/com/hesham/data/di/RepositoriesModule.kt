package com.hesham.data.di

import com.hesham.domain.repository.CategoriesRepository
import com.hesham.domain.repository.ProductRepository
import com.hesham.domain.repository.SubCategoryRepository
import com.hesham.data.repository.CategoriesRepositoryImpl
import com.hesham.data.repository.ProductsRepositoryImpl
import com.hesham.data.repository.SubCategoryRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoriesModule {


    @Provides
    @Singleton
    fun provideCategoriesRepository(impl: CategoriesRepositoryImpl): CategoriesRepository {
        return impl
    }

    @Provides
    @Singleton
    fun provideProductsRepository(impl: ProductsRepositoryImpl): ProductRepository {
        return impl
    }

    @Provides
    @Singleton
    fun provideSubCategoryRepository(impl: SubCategoryRepositoryImpl): SubCategoryRepository {
        return impl
    }


}