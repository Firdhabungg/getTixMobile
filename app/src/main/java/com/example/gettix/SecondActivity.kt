package com.example.gettix

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {
    @SuppressLint("QueryPermissionsNeeded", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val content: TextView = findViewById(R.id.content)
        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")
        content.text = "Email: $email\nPassword: $password"

        val btnImplicit: Button = findViewById(R.id.btnImplicit)
        btnImplicit.setOnClickListener {
            //intent Implicit
            val intentYoutube = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com"))
                startActivity(intentYoutube)
        }

    }
}