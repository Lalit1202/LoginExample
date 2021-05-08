package com.example.loginexample

import android.content.Context
import android.content.SharedPreferences


class PrefManager internal constructor(context: Context) {
    var context: Context = context
    fun saveLoginDetails(email: String, password: String) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("Email", email)
        editor.putString("Password", password)
        editor.commit()
    }

    val email : String
        get() {
            val sharedPreferences: SharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE)
            return sharedPreferences.getString("Email", "").toString()
        }


    val password: String
        get() {
            val sharedPreferences: SharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE)
            return sharedPreferences.getString("Password", "").toString()
        }

}