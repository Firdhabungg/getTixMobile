 package com.example.gettix

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val emailInput: EditText = findViewById(R.id.emailInput)
        val passwordInput: EditText = findViewById(R.id.passwordInput)
        val btnLogin:Button = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
//            Intent Explicit
            val intentLogin = Intent(this, SecondActivity::class.java)
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()
            intentLogin.putExtra("email", email)
            intentLogin.putExtra("password", password)
            if(email.isNotEmpty() && password.isNotEmpty()){
                Toast.makeText(applicationContext, "Data berhasil dikirimkan", Toast.LENGTH_SHORT).show()
                startActivity(intentLogin)
            }else {
                Toast.makeText(applicationContext, "Tidak ada data yang dikirimkan", Toast.LENGTH_SHORT).show()
            }

        }
    }
}