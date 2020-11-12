package com.myecommerce.pdp.di

import com.myecommerce.pdp.data.PdpRepositoryImp
import com.myecommerce.pdp.data.local.PdpLocalDataSource
import com.myecommerce.pdp.data.local.PdpLocalDataSourceImp
import com.myecommerce.pdp.domain.PdpRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * Created by Amro, Abd-Elgawwad on 09/11/2020.
 */
@Module
@InstallIn(ActivityComponent::class)
interface PdpBindsModule {

    @Binds
    fun provideRepository(repositoryImp: PdpRepositoryImp): PdpRepository

    @Binds
    fun provideLocalDataSource(localDataSourceImp: PdpLocalDataSourceImp): PdpLocalDataSource
}