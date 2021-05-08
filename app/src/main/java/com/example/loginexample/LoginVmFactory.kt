package com.example.loginexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LoginVmFactory : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginVM() as T
    }
}