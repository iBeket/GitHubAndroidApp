package com.example.githubapplication.ui.userRepoDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubapplication.api.helper.GitHubRepositoryDetails

class UserRepoDetailsViewModelFactory(private val gitHubRepo: GitHubRepositoryDetails) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserRepoDetailsViewModel(gitHubRepo) as T
    }
}