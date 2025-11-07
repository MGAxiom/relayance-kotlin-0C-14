package com.kirabium.relayance.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.kirabium.relayance.domain.model.model.Customer
import com.kirabium.relayance.domain.model.repository.CustomerRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import java.util.Date

class DetailViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var customerRepository: CustomerRepository
    private lateinit var viewModel: DetailViewModel

    @Before
    fun setUp() {
        customerRepository = mock(CustomerRepository::class.java)
        viewModel = DetailViewModel(customerRepository)
    }

    @Test
    fun `loadCustomer with valid id should update customer livedata`() {
        val customerId = 1
        val expectedCustomer = Customer(customerId, "Test Customer", "test@example.com", Date())
        `when`(customerRepository.getCustomerById(customerId)).thenReturn(expectedCustomer)

        viewModel.loadCustomer(customerId)

        assertEquals(expectedCustomer, viewModel.customer.value)
    }

    @Test
    fun `loadCustomer with invalid id should keep customer livedata null`() {
        val invalidId = -1
        `when`(customerRepository.getCustomerById(invalidId)).thenReturn(null)

        viewModel.loadCustomer(invalidId)

        assertNull(viewModel.customer.value)
    }
}