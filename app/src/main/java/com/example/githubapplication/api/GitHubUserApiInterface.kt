package com.example.githubapplication.api

import com.example.githubapplication.api.models.GitHubUserModel
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubUserApiInterface {

    @GET("users/{username}")
    fun getUserInfo(
        @Path("username") username: String
    ): Single<Response<GitHubUserModel>>
}