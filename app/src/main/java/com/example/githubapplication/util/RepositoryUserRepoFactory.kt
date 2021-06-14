package com.example.githubapplication.util

import com.example.githubapplication.api.GitHubUserRepoApiInterface
import com.example.githubapplication.api.helper.GitHubRepositoryDetails
object RepositoryUserRepoFactory {
    fun createGithubRepository(): GitHubRepositoryDetails {
        val githubApi = ApiClient.instance.retrofit.create(GitHubUserRepoApiInterface::class.java)
        return GitHubRepositoryDetails(githubApi)
    }
}