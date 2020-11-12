package com.myecommerce.search.di

import com.myecommerce.search.data.SearchRepositoryImp
import com.myecommerce.search.data.local.SearchLocalDataSource
import com.myecommerce.search.data.local.SearchLocalDataSourceImp
import com.myecommerce.search.domain.SearchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * Created by Amro, Abd-Elgawwad on 09/11/2020.
 */
@Module
@InstallIn(ActivityComponent::class)
interface SearchBindsModule {
    @Binds
    fun provideRepository(repositoryImp: SearchRepositoryImp): SearchRepository

    @Binds
    fun provideLocalDataSource(localDataSourceImp: SearchLocalDataSourceImp): SearchLocalDataSource
}