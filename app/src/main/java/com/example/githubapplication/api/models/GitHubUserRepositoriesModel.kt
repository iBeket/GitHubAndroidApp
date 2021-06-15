package com.example.githubapplication.api.models

import com.google.gson.annotations.SerializedName

data class GitHubUserRepositoriesModel(
    @SerializedName("name") var repoName: String,
    @SerializedName("open_issues") var totalCount: Int,
    @SerializedName("default_branch") var defaultBranch: String,
    @SerializedName("watchers") var watchers: Int,
    @SerializedName("size") var size: Int
)
