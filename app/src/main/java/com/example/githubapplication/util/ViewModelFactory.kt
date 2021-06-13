package com.example.githubapplication.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubapplication.api.GithubUserRepo
import com.example.githubapplication.ui.userDetails.UserDetailsActivityViewModel

class ViewModelFactory (private val githubRepo: GithubUserRepo) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserDetailsActivityViewModel(githubRepo) as T
    }
}