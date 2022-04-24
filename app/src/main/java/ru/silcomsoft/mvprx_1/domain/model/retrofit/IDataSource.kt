package ru.silcomsoft.mvprx_1.domain.model.retrofit

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url
import ru.silcomsoft.mvprx_1.domain.model.GithubRepository
import ru.silcomsoft.mvprx_1.domain.model.GithubUser

interface IDataSource {
    @GET("/users")
    fun getUsers(): Single<List<GithubUser>>

    @GET("users/{login}")
    fun getUserDetails(@Path("login") login: String): Single<GithubUser>

    @GET
    fun getRepos(@Url url : String) : Single<List<GithubRepository>>

}

