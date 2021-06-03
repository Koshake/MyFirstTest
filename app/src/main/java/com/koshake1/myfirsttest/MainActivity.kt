package com.koshake1.myfirsttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.koshake1.myfirsttest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val emailValidator = EmailValidator()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initEmailValidator()
    }

    private fun initEmailValidator() {
        with(binding) {
            emailInput.addTextChangedListener(emailValidator)

            saveButton.setOnClickListener {
                if (emailValidator.isValid) {
                    Toast.makeText(this@MainActivity, getString(R.string.valid_email), Toast.LENGTH_SHORT).show()
                } else {
                    emailInput.error = getString(R.string.invalid_email)
                    Toast.makeText(this@MainActivity, getString(R.string.invalid_email), Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}