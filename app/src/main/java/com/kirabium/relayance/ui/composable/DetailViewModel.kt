package com.kirabium.relayance.ui.composable

import androidx.lifecycle.ViewModel
import com.kirabium.relayance.domain.model.model.Customer
import com.kirabium.relayance.domain.model.repository.CustomerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val customerRepository: CustomerRepository
): ViewModel() {

    fun getCustomerList(): List<Customer> {
        return customerRepository.getCustomers()
    }
}