package com.example.githubapplication.util

import com.example.githubapplication.api.GitHubUserApiInterface
import com.example.githubapplication.api.GithubUserRepo

object RepositoryFactory {

    fun createGithubRepository() : GithubUserRepo {
        val githubApi = ApiClient.instance.retrofit.create(GitHubUserApiInterface::class.java)
        return GithubUserRepo(githubApi)
    }
}