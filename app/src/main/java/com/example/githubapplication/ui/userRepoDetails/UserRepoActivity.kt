package com.example.githubapplication.ui.userRepoDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubapplication.R
import com.example.githubapplication.api.models.GitHubUserRepositoriesModel
import com.example.githubapplication.ui.userRepoDetails.adapter.UserRepoAdapter
import com.example.githubapplication.util.RepositoryUserRepoFactory

class UserRepoActivity : AppCompatActivity() {

    private lateinit var viewModel: UserRepoDetailsViewModel
    private var adapter: UserRepoAdapter? = null
    private var userRepoInfo: MutableList<GitHubUserRepositoriesModel> =
        mutableListOf<GitHubUserRepositoriesModel>()
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_repo_details)

        viewModel = ViewModelProviders.of(
            this, UserRepoDetailsViewModelFactory(
                RepositoryUserRepoFactory.createGithubRepository()
            )
        ).get(UserRepoDetailsViewModel::class.java)

        userRepoInfo = mutableListOf()

        recyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = UserRepoAdapter(userRepoInfo, this)
        recyclerView.adapter = adapter

        viewModel.getGithubAccountRepo("octocat")

        getUsersData()
    }

    private fun getUsersData() {

        viewModel.githubAccountRepo.observe(this, Observer {
           adapter?.setItemList(it)
        })
        adapter?.notifyDataSetChanged()
    }
}