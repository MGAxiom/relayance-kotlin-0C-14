package com.kirabium.relayance

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kirabium.relayance.ui.activity.DetailActivity
import com.kirabium.relayance.ui.activity.MainActivity
import com.kirabium.relayance.util.RecyclerViewItemCountAssertion
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityInstrumentedTests {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun onActivityStarts_recyclerViewHasFiveItems() {
        onView(withId(R.id.customerRecyclerView)).check(
            RecyclerViewItemCountAssertion(5)
        )
    }

    @Test
    fun whenFirstElementIsClicked_detailActivityIsLaunchedWithCorrectId() {
        // Click on the first item in the RecyclerView
        onView(withId(R.id.customerRecyclerView))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        // Verify that the intent to DetailActivity was sent with the correct extra
        intended(hasComponent(DetailActivity::class.java.name))
        intended(hasExtra(DetailActivity.EXTRA_CUSTOMER_ID, 1))
    }
}