package com.kirabium.relayance.ui

import androidx.lifecycle.ViewModel
import com.kirabium.relayance.domain.model.repository.CustomerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddCustomerViewModel @Inject constructor(
    private val customerRepository: CustomerRepository
) : ViewModel() {

    fun addCustomer(name: String, email: String) {
        customerRepository.addCustomer(name, email)
    }
}