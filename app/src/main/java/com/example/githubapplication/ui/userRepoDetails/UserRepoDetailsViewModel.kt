package com.example.githubapplication.ui.userRepoDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubapplication.api.helper.GitHubRepositoryDetails
import com.example.githubapplication.api.models.GitHubUserRepositoriesModel

class UserRepoDetailsViewModel(val gitHubUserRepo: GitHubRepositoryDetails) : ViewModel() {

    private val _githubAccountRepo: MutableLiveData<MutableList<GitHubUserRepositoriesModel>> = MutableLiveData()
    val githubAccountRepo: LiveData<MutableList<GitHubUserRepositoriesModel>> = _githubAccountRepo

    fun getGithubAccountRepo(name: String) {
        gitHubUserRepo.fetchGithubRepoAccount(name)
            .subscribe {
                _githubAccountRepo.postValue(it)
            }
    }


}
