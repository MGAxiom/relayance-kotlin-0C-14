package com.kirabium.relayance

import android.os.Bundle
import io.cucumber.android.runner.CucumberAndroidJUnitRunner

/**
 * This is the main Cucumber test runner for the application.
 * It is configured in the app's build.gradle.kts file.
 */
class CucumberTestRunner : CucumberAndroidJUnitRunner() {
    override fun onCreate(arguments: Bundle?) {
        // The following line is optional, but it gives you pretty-printed logs
        arguments?.putString("plugin", "pretty")
        super.onCreate(arguments)
    }
}
