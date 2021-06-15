package com.example.githubapplication.api.models

import com.google.gson.annotations.SerializedName

data class GitHubUserModel(
    @SerializedName("name") var name: String,
    @SerializedName("company") var company: String,
    @SerializedName("avatar_url") var avatarUrl: String,
)
