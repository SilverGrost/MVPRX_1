package ru.silcomsoft.mvprx_1.domain.model.retrofit

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import ru.silcomsoft.mvprx_1.domain.model.GithubUser

interface IDataSource {
    @GET("users")
    fun getUsers(): Single<List<GithubUser>>

    @GET("users/{login}")
    fun getRepos(@Path("login") login: String): Single<GithubUser>

}

