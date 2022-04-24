package ru.silcomsoft.mvprx_1.domain.model.retrofit.repos

import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import ru.silcomsoft.mvprx_1.domain.model.GithubRepository
import ru.silcomsoft.mvprx_1.domain.model.GithubUser

interface IGithubReposByUser {
    fun getRepositories(user: GithubUser): @NonNull Single<List<GithubRepository>>?
}