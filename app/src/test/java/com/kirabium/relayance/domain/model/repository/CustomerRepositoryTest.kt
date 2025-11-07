package com.kirabium.relayance.domain.model.repository

import com.kirabium.relayance.data.DummyData
import com.kirabium.relayance.domain.model.model.Customer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import java.util.Date

class CustomerRepositoryTest {

    private lateinit var repository: CustomerRepository

    @Before
    fun setUp() {
        repository = CustomerRepositoryImpl()
        DummyData.customers.clear()
    }

    @Test
    fun `getCustomers should return all customers`() {
        DummyData.customers.addAll(
            listOf(
                Customer(1, "Alice Wonderland", "alice@example.com", DummyData.generateDate(12)),
                Customer(2, "Bob Builder", "bob@example.com", DummyData.generateDate(6))
            )
        )

        val customers = repository.getCustomers()

        assertEquals(2, customers.size)
    }

    @Test
    fun `getCustomerById with valid id should return the correct customer`() {
        DummyData.customers.add(Customer(1, "Alice Wonderland", "alice@example.com", DummyData.generateDate(12)))

        val customer = repository.getCustomerById(1)

        assertNotNull(customer)
        assertEquals("Alice Wonderland", customer?.name)
    }

    @Test
    fun `getCustomerById with invalid id on empty list should return null`() {
        val customer = repository.getCustomerById(99)
        assertNull(customer)
    }

    @Test
    fun `getCustomerById with invalid id on populated list should return null`() {
        DummyData.customers.add(Customer(1, "Alice Wonderland", "alice@example.com", DummyData.generateDate(12)))

        val customer = repository.getCustomerById(99)

        assertNull(customer)
    }

    @Test
    fun `addCustomer should add a customer with the correct new ID to a populated list`() {
        DummyData.customers.add(Customer(5, "Existing Customer", "e@e.com", Date()))
        val initialSize = repository.getCustomers().size

        repository.addCustomer("New Customer", "new@example.com")
        val updatedCustomers = repository.getCustomers()

        assertEquals(initialSize + 1, updatedCustomers.size)
        assertEquals(6, updatedCustomers.last().id) // Verifies maxOfOrNull (5) + 1 = 6
    }

    @Test
    fun `addCustomer to empty list should result in id 1`() {
        repository.addCustomer("First Customer", "first@example.com")

        val customers = repository.getCustomers()
        assertEquals(1, customers.size)
        assertEquals(1, customers.first().id) // Verifies (maxOfOrNull is null ? 0) + 1 = 1
    }
}