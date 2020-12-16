package com.c2r.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isGone


class MainActivity : AppCompatActivity() {

    lateinit var nicknameEdit : EditText
    lateinit var nicknameText : TextView
    lateinit var doneButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nicknameEdit = findViewById(R.id.et_nickname)
        nicknameText = findViewById(R.id.nickname_text)
        doneButton = findViewById(R.id.done_button)

        doneButton.setOnClickListener { addNewNickname(it) }
        nicknameText.setOnClickListener { changeNickname(it) }

    }

    private fun addNewNickname(view: View) {

        nicknameText.text = nicknameEdit.text
        nicknameEdit.visibility = View.GONE
        view.visibility = View.GONE
        nicknameText.visibility = View.VISIBLE
        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

    }

    fun changeNickname(view: View) {

        view.visibility = View.GONE
        nicknameEdit.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        nicknameEdit.requestFocus()
        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(nicknameEdit, 0)

    }


}