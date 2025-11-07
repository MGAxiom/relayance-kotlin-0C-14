package com.kirabium.relayance.test

import io.cucumber.junit.CucumberOptions

/**
 * This class provides the Cucumber options for the test runner.
 * It should not be run directly.
 */
@CucumberOptions(
    features = ["features"],
    glue = ["com.kirabium.relayance.features"]
)
class CucumberTest