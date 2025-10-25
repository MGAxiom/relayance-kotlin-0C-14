package com.kirabium.relayance.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kirabium.relayance.databinding.ActivityAddCustomerBinding
import com.kirabium.relayance.ui.AddCustomerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddCustomerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddCustomerBinding
    private val viewModel: AddCustomerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupToolbar()
        setupAddButton()
    }

    private fun setupToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Add Customer"
    }

    private fun setupBinding() {
        binding = ActivityAddCustomerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun setupAddButton() {
//        binding.addButton.setOnClickListener {
//            val name = binding.nameEditText.text.toString()
//            val email = binding.emailEditText.text.toString()
//
//            if (name.isNotBlank() && email.isNotBlank()) {
//                viewModel.addCustomer(name, email)
//                finish()
//            }
//        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}