

package com.example.loginexample

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable

import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.databinding.adapters.TextViewBindingAdapter.setText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import com.example.loginexample.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    private lateinit var sharePreferences:SharedPreferences



    private lateinit var ed1:EditText
    private lateinit var ed2:EditText
    private lateinit var viewModel:LoginVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val dataBinding = setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        sharePreferences = getSharedPreferences("Prefs", Context.MODE_PRIVATE)

        viewModel = ViewModelProviders.of(this,LoginVmFactory()).get(LoginVM::class.java)
        dataBinding.viewModel = viewModel


        ed1 = dataBinding.email
        ed2 = dataBinding.password
        dataBinding.lifecycleOwner = this

        dataBinding.executePendingBindings()
        dataBinding.button2.setOnClickListener {
            if(dataBinding.checkBox.isChecked)
            {
                val boolCheck:Boolean = dataBinding.checkBox.isChecked
                val editor = sharePreferences.edit()
                editor.putString("email",viewModel.data.getEmail())
                editor.putString("pass",viewModel.data.getPassword())
                editor.putBoolean("check",boolCheck)
                editor.apply()
                Toast.makeText(this,viewModel.data.getEmail(),Toast.LENGTH_LONG).show()


            }
            else
            {
                sharePreferences.edit().clear().apply()
            }

            dataBinding.email.text.clear()
            dataBinding.password.text.clear()
        }
        getData()

    }

    private fun getData() {
        val  sp = getSharedPreferences("Prefs", Context.MODE_PRIVATE)
        if(sp.contains("email"))
        {
            var em: String? = sp.getString("email","not found")
            ed1.setText(em)

        }
        if(sp.contains("pass"))
        {
            var p  = sp.getString("pass","not found")
            ed2.setText(p)
        }
        if(sp.contains("check"))
        {
            var b  = sp.getBoolean("check",false)
            checkBox.isChecked = b
        }
    }


}

