package com.kirabium.relayance.data

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Calendar

class DummyDataTest {

    @Test
    fun generateDate() {
        // Given
        val monthsBack = 6
        val expectedCalendar = Calendar.getInstance()
        expectedCalendar.add(Calendar.MONTH, -monthsBack)

        // When
        val resultDate = DummyData.generateDate(monthsBack)
        val resultCalendar = Calendar.getInstance()
        resultCalendar.time = resultDate

        // Then
        assertEquals(expectedCalendar.get(Calendar.YEAR), resultCalendar.get(Calendar.YEAR))
        assertEquals(expectedCalendar.get(Calendar.MONTH), resultCalendar.get(Calendar.MONTH))
    }

    @Test
    fun customersList_isNotEmpty() {
        // When
        val customers = DummyData.customers

        // Then
        assertEquals(5, customers.size)
    }
}