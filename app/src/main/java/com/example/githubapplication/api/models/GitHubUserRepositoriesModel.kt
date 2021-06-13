package com.example.githubapplication.api.models

import com.google.gson.annotations.SerializedName

data class GitHubUserRepositoriesModel(
    @SerializedName("total_count") var totalCount: Long,
    @SerializedName("incomplete_results") var incompleteResults: Boolean,
    @SerializedName("items") var items: List<GitHubUserModel>
)
