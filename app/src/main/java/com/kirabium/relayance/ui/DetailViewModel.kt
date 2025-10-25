package com.kirabium.relayance.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kirabium.relayance.domain.model.model.Customer
import com.kirabium.relayance.domain.model.repository.CustomerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val customerRepository: CustomerRepository
): ViewModel() {

    private val _customer = MutableLiveData<Customer>()
    val customer: LiveData<Customer> = _customer

    fun loadCustomer(customerId: Int) {
        _customer.value = customerRepository.getCustomerById(customerId)
    }
}