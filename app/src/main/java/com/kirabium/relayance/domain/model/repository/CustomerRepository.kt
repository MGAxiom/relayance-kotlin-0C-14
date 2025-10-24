package com.kirabium.relayance.domain.model.repository

import com.kirabium.relayance.data.DummyData
import com.kirabium.relayance.domain.model.model.Customer


interface CustomerRepository {
    fun getCustomers(): List<Customer>
}

class CustomerRepositoryImpl : CustomerRepository {
    override fun getCustomers(): List<Customer> {
       return DummyData.customers
    }
}