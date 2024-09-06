package com.aneeque.mvvm.ui

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.aneeque.mvvm.MyApp
import com.aneeque.mvvm.R
import com.aneeque.mvvm.db.User
import com.google.android.material.textfield.TextInputEditText

class SignUp : AppCompatActivity(), View.OnClickListener {

    private lateinit var etEmail: TextInputEditText
    private lateinit var etUsername: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var btnSignUp: Button
    private lateinit var btnBack: AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        initUI()
        initListeners()
    }

    private fun initUI() {
        etEmail = findViewById(R.id.etEmail)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnSignUp = findViewById(R.id.btnSignUp)
        btnBack = findViewById(R.id.btnBack)
    }

    private fun initListeners() {
        btnSignUp.setOnClickListener(this)
        btnBack.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnSignUp -> {
                val email = etEmail.text.toString()
                val username = etUsername.text.toString()
                val password = etPassword.text.toString()
                if (email.isNotEmpty() && !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(this, "Enter valid email address", Toast.LENGTH_SHORT).show();
                } else {
                    val numberOfUsers = MyApp.roomDB.userDao().getAll().size + 1
                    val newUser =
                        User(numberOfUsers, email = email, username = username, password = password)
                    MyApp.roomDB.userDao().insertUser(newUser)
                    Toast.makeText(this, "User added to database", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }

            R.id.btnBack -> {
                finish()
            }
        }
    }
}