package com.example.githubapplication.ui.userDetails

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.githubapplication.R
import com.example.githubapplication.util.RepositoryFactory
import com.example.githubapplication.util.ViewModelFactory
import com.squareup.picasso.Picasso


class UserDetailsActivity : AppCompatActivity() {

    private lateinit var userDetailsActivityViewModel: UserDetailsActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_details_activity)

        val userName: TextView = findViewById<TextView>(R.id.user_name)
        val companyName: TextView = findViewById<TextView>(R.id.company_name)
        val avatarUrl: ImageView = findViewById<ImageView>(R.id.avatar)


        userDetailsActivityViewModel = ViewModelProviders.of(
            this, ViewModelFactory(
                RepositoryFactory.createGithubRepository()
            )
        ).get(UserDetailsActivityViewModel::class.java)

        userDetailsActivityViewModel.githubAccount.observe(this, Observer {
            userName.text = it.name
            companyName.text = it.company
            Picasso.get().load(it.avatarUrl).resize(150,150).into(avatarUrl)
        })

        userDetailsActivityViewModel.getGithubAccount("octocat")
    }
}