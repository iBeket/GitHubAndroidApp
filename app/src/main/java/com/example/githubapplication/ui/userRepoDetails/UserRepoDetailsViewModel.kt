package com.example.githubapplication.ui.userRepoDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubapplication.api.helper.GitHubRepositoryDetails
import com.example.githubapplication.api.models.GitHubUserRepositoriesModel

class UserRepoDetailsViewModel(val githubRepo: GitHubRepositoryDetails) : ViewModel() {

    private val _githubAccount: MutableLiveData<MutableList<GitHubUserRepositoriesModel>> = MutableLiveData()
    val githubAccount: LiveData<MutableList<GitHubUserRepositoriesModel>> = _githubAccount

    fun getGithubAccount(name: String) {
        githubRepo.fetchGithubAccount(name)
            .subscribe {
                _githubAccount.postValue(it)
            }
    }


}
