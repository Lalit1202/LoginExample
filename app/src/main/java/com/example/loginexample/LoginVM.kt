package com.example.loginexample

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import java.util.*


class LoginVM : ViewModel() {
     val data:LoginData = LoginData("","")



    val emailTextWatcher:TextWatcher
        get() =object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                data.setEmail(s.toString())

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        }

    val passwordTextWatcher:TextWatcher
        get() =object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                data.setPassword(s.toString())

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        }
}
