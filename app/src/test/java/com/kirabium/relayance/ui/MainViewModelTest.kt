package com.kirabium.relayance.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.kirabium.relayance.domain.model.model.Customer
import com.kirabium.relayance.domain.model.repository.CustomerRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import java.util.Date

class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var customerRepository: CustomerRepository
    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        customerRepository = mock(CustomerRepository::class.java)
        viewModel = MainViewModel(customerRepository)
    }

    @Test
    fun `loadCustomers should update customers livedata`() {
        val expectedCustomers = listOf(
            Customer(1, "Customer 1", "c1@example.com", Date()),
            Customer(2, "Customer 2", "c2@example.com", Date())
        )
        `when`(customerRepository.getCustomers()).thenReturn(expectedCustomers)

        viewModel.loadCustomers()

        assertEquals(expectedCustomers, viewModel.customers.value)
    }
}
