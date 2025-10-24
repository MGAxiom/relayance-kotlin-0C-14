package com.kirabium.relayance.util

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kirabium.relayance.R
import com.kirabium.relayance.ui.activity.MainActivity
import org.junit.Rule
import org.junit.Test

class MainActivityInstrumented {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun onActivityStarts_recyclerViewHasFiveItems() {
        onView(withId(R.id.customerRecyclerView)).check(
            RecyclerViewItemCountAssertion(5)
        )
    }
}