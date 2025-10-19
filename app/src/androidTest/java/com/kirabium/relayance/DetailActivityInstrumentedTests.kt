package com.kirabium.relayance

import android.content.Intent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.assertTextEquals
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import com.kirabium.relayance.data.DummyData
import com.kirabium.relayance.extension.DateExt.Companion.toHumanDate
import com.kirabium.relayance.ui.activity.DetailActivity
import org.junit.Rule
import org.junit.Test

class DetailActivityInstrumentedTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun onActivityStarts_hasCustomerInformation() {
        val intent = Intent(ApplicationProvider.getApplicationContext(), DetailActivity::class.java).apply {
            putExtra(DetailActivity.EXTRA_CUSTOMER_ID, 1)
        }
        ActivityScenario.launch<DetailActivity>(intent)

        val customer = DummyData.customers.first { it.id == 1 }

        composeTestRule.onNodeWithTag("name").assertIsDisplayed().assertTextEquals(customer.name)
        composeTestRule.onNodeWithTag("email").assertIsDisplayed().assertTextEquals(customer.email)
        composeTestRule.onNodeWithTag("creationDate").assertIsDisplayed().assertTextEquals("Created at: ${customer.createdAt.toHumanDate()}")
    }
}