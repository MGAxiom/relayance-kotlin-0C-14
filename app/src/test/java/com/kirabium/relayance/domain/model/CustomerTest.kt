package com.kirabium.relayance.domain.model

import com.kirabium.relayance.domain.model.model.Customer
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.Calendar
import java.util.Date

class CustomerTest {

    private fun getDate(monthsAgo: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, -monthsAgo)
        return calendar.time
    }

    @Test
    fun `isNewCustomer should return false for customer older than 3 months`() {
        // Given
        val oldCustomer = Customer(1, "Old Customer", "old@test.com", getDate(4))

        // When
        val isNew = oldCustomer.isNewCustomer()

        // Then
        assertFalse(isNew)
    }

    @Test
    fun `isNewCustomer should return true for customer newer than 3 months`() {
        // Given
        val newCustomer = Customer(1, "New Customer", "new@test.com", getDate(2))

        // When
        val isNew = newCustomer.isNewCustomer()

        // Then
        assertTrue(isNew)
    }
}