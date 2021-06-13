package com.example.githubapplication.ui.userDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubapplication.api.GithubUserRepo
import com.example.githubapplication.api.models.GitHubUserModel

class UserDetailsActivityViewModel (val githubRepo: GithubUserRepo) : ViewModel() {

    private val _githubAccount: MutableLiveData<GitHubUserModel> = MutableLiveData()
    val githubAccount: LiveData<GitHubUserModel> = _githubAccount

    fun getGithubAccount(name: String) {
        githubRepo
            .fetchGithubAccount(name)
            .subscribe {
                _githubAccount.postValue(it)
            }

    }
}