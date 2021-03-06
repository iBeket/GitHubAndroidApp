package com.example.githubapplication.ui.userDetails

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.githubapplication.R
import com.example.githubapplication.ui.userRepoDetails.UserRepoActivity
import com.example.githubapplication.util.RepositoryFactory

class UserDetailsActivity : AppCompatActivity() {

    private lateinit var userDetailsActivityViewModel: UserDetailsActivityViewModel
    lateinit var context: Context
    private val sharedPrefFile = "sharedUserName"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_details_activity)

        context = this
        val sharedPreferences: SharedPreferences =
            this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
        val userNameFormSharedPref: String = sharedPreferences.getString("userName", "").toString()

        val userName: TextView = findViewById<TextView>(R.id.user_name)
        val companyName: TextView = findViewById<TextView>(R.id.company_name)
        val avatarUrl: ImageView = findViewById<ImageView>(R.id.avatar)
        val viewRepoButton: Button = findViewById<Button>(R.id.view_user_repo_button)

        userDetailsActivityViewModel = ViewModelProvider(
            this, ViewModelFactory(
                RepositoryFactory.createGithubRepository()
            )
        ).get(UserDetailsActivityViewModel::class.java)

        userDetailsActivityViewModel.githubAccount.observe(this, Observer {
            userName.text = it.name
            companyName.text = it.company
            Glide.with(context).load(it.avatarUrl).apply(RequestOptions.circleCropTransform())
                .into(avatarUrl)

        })
        userDetailsActivityViewModel.getGithubAccount(userNameFormSharedPref)

        viewRepoButton.setOnClickListener {
            val intent = Intent(context, UserRepoActivity::class.java)
            startActivity(intent)
        }
    }
}