package com.example.githubapplication.api

import com.example.githubapplication.api.models.GitHubUserModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubUserRepoApiInterface {
    @GET("/users/{user}/repos")
    suspend fun getUserInfo(
        @Path("user") user: String
    ): Response<GitHubUserModel>
}