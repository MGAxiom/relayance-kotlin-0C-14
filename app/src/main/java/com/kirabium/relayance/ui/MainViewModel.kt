package com.kirabium.relayance.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kirabium.relayance.domain.model.model.Customer
import com.kirabium.relayance.domain.model.repository.CustomerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val customerRepository: CustomerRepository
): ViewModel() {

    private val _customers = MutableLiveData<List<Customer>>()
    val customers: LiveData<List<Customer>> = _customers

    fun loadCustomers() {
        _customers.value = customerRepository.getCustomers()
    }
}