package com.aneeque.mvvm.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aneeque.mvvm.MyApp
import com.aneeque.mvvm.R
import com.google.android.material.textfield.TextInputEditText

class Login : AppCompatActivity(), View.OnClickListener {

    private lateinit var etUsername: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var btnSignIn: Button
    private lateinit var btnSignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initUI()
        initListeners()
    }

    private fun initUI() {
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnSignIn = findViewById(R.id.btnSignIn)
        btnSignUp = findViewById(R.id.btnSignUp)
    }

    private fun initListeners() {
        btnSignIn.setOnClickListener(this)
        btnSignUp.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnSignIn -> {
                val username = etUsername.text.toString()
                val password = etPassword.text.toString()

                val user = MyApp.roomDB.userDao().findByUsername(username)

                if (user.password == password) {
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
                }
            }

            R.id.btnSignUp -> {
                startActivity(Intent(this, SignUp::class.java))
            }
        }
    }
}