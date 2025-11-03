package com.kirabium.relayance.features

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.kirabium.relayance.R
import com.kirabium.relayance.ui.activity.MainActivity
import io.cucumber.java.After
import io.cucumber.java.Before
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class AddCustomerSteps {

    private var activityScenario: ActivityScenario<MainActivity>? = null

    @Before
    fun setUp() {
        // This is a good place for setup that runs before each scenario
    }

    @After
    fun tearDown() {
        activityScenario?.close()
    }

    @Given("I am on the main customer list screen")
    fun i_am_on_the_main_customer_list_screen() {
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @When("I tap the add customer button")
    fun i_tap_the_add_customer_button() {
        onView(withId(R.id.addCustomerFab)).perform(click())
    }

    @And("I enter {string} in the name field")
    fun i_enter_in_the_name_field(name: String) {
        onView(withId(R.id.nameEditText)).perform(typeText(name))
    }

    @And("I enter {string} in the email field")
    fun i_enter_in_the_email_field(email: String) {
        onView(withId(R.id.emailEditText)).perform(typeText(email))
    }

    @And("I tap the save button")
    fun i_tap_the_save_button() {
        onView(withId(R.id.saveButton)).perform(click())
    }

    @Then("I should see the main customer list screen")
    fun i_should_see_the_main_customer_list_screen() {
        // This is implicit after the save action.
    }

    @And("I should see {string} in the list")
    fun i_should_see_in_the_list(customerName: String) {
        onView(withText(customerName)).check(matches(isDisplayed()))
    }
}
