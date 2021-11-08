package ru.silcomsoft.mvprx_1.domain.model.retrofit.users

import io.reactivex.rxjava3.core.Single
import ru.silcomsoft.mvprx_1.domain.model.GithubUser

interface IGithubUsersRepo {
    fun getUsers(): Single<List<GithubUser>>
}