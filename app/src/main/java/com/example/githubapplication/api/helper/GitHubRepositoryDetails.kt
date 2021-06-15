package com.example.githubapplication.api.helper

import com.example.githubapplication.api.GitHubUserRepoApiInterface
import com.example.githubapplication.api.models.GitHubUserRepositoriesModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GitHubRepositoryDetails(val githubApi: GitHubUserRepoApiInterface) {

    fun fetchGithubRepoAccount(name: String): Observable<MutableList<GitHubUserRepositoriesModel>> {
        return Observable.create { emitter ->

            githubApi.getUserInfoRepo(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.body() != null) {
                        emitter.onNext(it.body()!!)
                    }
                }, {
                    it.printStackTrace()
                })
        }
    }
}