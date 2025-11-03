package com.kirabium.relayance.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.kirabium.relayance.domain.model.repository.CustomerRepository
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.never
import org.mockito.Mockito.verify

class AddCustomerViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var customerRepository: CustomerRepository
    private lateinit var viewModel: AddCustomerViewModel

    @Before
    fun setUp() {
        customerRepository = mock(CustomerRepository::class.java)
        viewModel = AddCustomerViewModel(customerRepository)
    }

    @Test
    fun `addCustomer with invalid email should not call repository`() {
        // Given
        val name = "Test Customer"
        val invalidEmail = "invalid-email"

        // When
        viewModel.addCustomer(name, invalidEmail)

        // Then
        verify(customerRepository, never()).addCustomer(name, invalidEmail)
    }

    @Test
    fun `addCustomer with valid data should trigger success event`() {
        // Given
        val name = "Test Customer"
        val validEmail = "test@example.com"

        // When
        viewModel.addCustomer(name, validEmail)

        // Then
        assertNotNull(viewModel.showToast.value)
    }
}