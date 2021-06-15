package com.example.githubapplication.ui.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.githubapplication.R
import com.example.githubapplication.ui.userDetails.UserDetailsActivity

class LogInActivity : AppCompatActivity() {

    lateinit var context: Context
    private val sharedPrefFile = "sharedUserName"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        context = this

        val sharedPreferences: SharedPreferences =
            this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)

        val userName: EditText = findViewById<EditText>(R.id.editText)
        val loginButton: Button = findViewById<Button>(R.id.login_button)

        loginButton.setOnClickListener {
            val userNameText = userName.text.toString()

            if (userNameText.isEmpty()) {
                Toast.makeText(this, "Please enter User Name", Toast.LENGTH_LONG).show()
            } else {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("userName", userNameText)
                editor.apply()
                editor.commit()
                val intent = Intent(context, UserDetailsActivity::class.java)
                startActivity(intent)
            }
        }
    }
}