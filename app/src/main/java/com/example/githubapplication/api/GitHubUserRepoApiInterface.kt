package com.example.githubapplication.api

import com.example.githubapplication.api.models.GitHubUserRepositoriesModel
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubUserRepoApiInterface {
    @GET("/users/{user}/repos")
    fun getUserInfoRepo(
        @Path("user") user: String
    ): Single<Response<MutableList<GitHubUserRepositoriesModel>>>
}