package com.example.kotlinpractice2

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        // 1. Find Views
        val tabSignIn = findViewById<TextView>(R.id.tabSignIn)
        val tabSignUp = findViewById<TextView>(R.id.tabSignUp)
        val layoutLogin = findViewById<LinearLayout>(R.id.layoutLogin)
        val layoutRegister = findViewById<LinearLayout>(R.id.layoutRegister)
        val btnLoginAction = findViewById<Button>(R.id.btnLoginAction)
        val btnRegisterAction = findViewById<Button>(R.id.btnRegisterAction)

        // 2. Function to Switch Tabs
        fun updateTabs(isLogin: Boolean) {
            if (isLogin) {
                // Style Sign In as Active
                tabSignIn.background = ContextCompat.getDrawable(this, R.drawable.bg_toggle_selected)
                tabSignIn.setTextColor(Color.BLACK)

                // Style Sign Up as Inactive
                tabSignUp.background = null
                tabSignUp.setTextColor(Color.GRAY)

                // Show Login Layout
                layoutLogin.visibility = View.VISIBLE
                layoutRegister.visibility = View.GONE
            } else {
                // Style Sign In as Inactive
                tabSignIn.background = null
                tabSignIn.setTextColor(Color.GRAY)

                // Style Sign Up as Active
                tabSignUp.background = ContextCompat.getDrawable(this, R.drawable.bg_toggle_selected)
                tabSignUp.setTextColor(Color.BLACK)

                // Show Register Layout
                layoutLogin.visibility = View.GONE
                layoutRegister.visibility = View.VISIBLE
            }
        }

        // 3. Click Listeners for Tabs
        tabSignIn.setOnClickListener { updateTabs(true) }
        tabSignUp.setOnClickListener { updateTabs(false) }

        // 4. Click Listeners for Buttons (Just for demo)
        btnLoginAction.setOnClickListener {
            Toast.makeText(this, "Logging In...", Toast.LENGTH_SHORT).show()
        }

        btnRegisterAction.setOnClickListener {
            Toast.makeText(this, "Creating Account...", Toast.LENGTH_SHORT).show()
        }
    }
}