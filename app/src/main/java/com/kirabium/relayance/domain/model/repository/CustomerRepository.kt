package com.kirabium.relayance.domain.model.repository

import com.kirabium.relayance.data.DummyData
import com.kirabium.relayance.domain.model.model.Customer
import java.util.Date


interface CustomerRepository {
    fun getCustomers(): List<Customer>

    fun getCustomerById(customerId: Int): Customer

    fun addCustomer(name: String, email: String)
}

class CustomerRepositoryImpl : CustomerRepository {
    override fun getCustomers(): List<Customer> {
       return DummyData.customers
    }

    override fun getCustomerById(customerId: Int): Customer {
        return DummyData.customers.first { it.id == customerId }
    }

    override fun addCustomer(name: String, email: String) {
        val newId = (DummyData.customers.maxOfOrNull { it.id } ?: 0) + 1
        val newCustomer = Customer(
            id = newId,
            name = name,
            email = email,
            createdAt = Date()
        )
        DummyData.customers.add(newCustomer)
    }
}