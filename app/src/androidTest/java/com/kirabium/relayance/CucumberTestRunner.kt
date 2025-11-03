package com.kirabium.relayance

import android.os.Bundle
import io.cucumber.android.runner.CucumberAndroidJUnitRunner
import io.cucumber.junit.CucumberOptions

@CucumberOptions(
    features = ["features"],
    glue = ["com.kirabium.relayance.features"]
)
class CucumberTestRunner : CucumberAndroidJUnitRunner() {
    override fun onCreate(arguments: Bundle?) {
        arguments?.putString("plugin", "pretty")
        super.onCreate(arguments)
    }
}