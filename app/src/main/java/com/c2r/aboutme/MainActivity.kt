package com.c2r.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.c2r.aboutme.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.doneButton.setOnClickListener { addNewNickname(it) }
        binding.nicknameText.setOnClickListener { changeNickname(it) }
    }

    private fun addNewNickname(view: View) {

        binding.apply {
            nicknameText.text = etNickname.text
            etNickname.visibility = GONE
            view.visibility = GONE
            nicknameText.visibility = VISIBLE
        }
        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun changeNickname(view: View) {

        binding.apply {
            view.visibility = GONE
            etNickname.visibility = VISIBLE
            doneButton.visibility = VISIBLE
            etNickname.requestFocus()
        }
        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.etNickname, 0)
    }

}