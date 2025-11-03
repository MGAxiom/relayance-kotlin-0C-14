package com.kirabium.relayance.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kirabium.relayance.domain.model.repository.CustomerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class AddCustomerViewModel @Inject constructor(
    private val customerRepository: CustomerRepository
) : ViewModel() {

    private val _showToast = MutableLiveData<String>()
    val showToast: LiveData<String> = _showToast

    fun addCustomer(name: String, email: String) {
        if (isEmailValid(email)) {
            customerRepository.addCustomer(name, email)
            _showToast.value = "Customer added successfully"
        } else {
            _showToast.value = "Invalid email format"
        }
    }

    private fun isEmailValid(email: String): Boolean {
        // A more standard and robust email validation regex
        return Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE
        ).matcher(email).matches()
    }
}
