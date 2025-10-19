package com.kirabium.relayance.extension

import com.kirabium.relayance.extension.DateExt.Companion.toHumanDate
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Calendar

class DateExtTest {

    @Test
    fun `toHumanDate should format the date correctly`() {
        // Given
        val calendar = Calendar.getInstance()
        calendar.set(2023, Calendar.OCTOBER, 26) // Month is 0-based
        val date = calendar.time

        // When
        val formattedDate = date.toHumanDate()

        // Then
        assertEquals("26/10/2023", formattedDate)
    }
}