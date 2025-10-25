package com.kirabium.relayance.di

import com.kirabium.relayance.domain.model.repository.CustomerRepository
import com.kirabium.relayance.domain.model.repository.CustomerRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCustomerRepository(): CustomerRepository {
        return CustomerRepositoryImpl()
    }
}