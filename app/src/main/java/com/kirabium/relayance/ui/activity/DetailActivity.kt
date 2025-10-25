package com.kirabium.relayance.ui.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kirabium.relayance.ui.DetailViewModel
import com.kirabium.relayance.ui.composable.DetailScreen

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_CUSTOMER_ID = "customer_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        val customerId = intent.getIntExtra(EXTRA_CUSTOMER_ID, -1)
        setContent {
            DetailScreen(customerId = customerId) {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }
}


