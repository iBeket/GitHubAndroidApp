package com.example.githubapplication.api.helper

import com.example.githubapplication.api.GitHubUserApiInterface
import com.example.githubapplication.api.models.GitHubUserModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GithubUserRepo(val githubApi: GitHubUserApiInterface) {

    fun fetchGithubAccount(name: String): Observable<GitHubUserModel> {
        return Observable.create { emitter ->

            githubApi.getUserInfo(name)
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