package ru.silcomsoft.mvprx_1.domain.repository

import io.reactivex.rxjava3.subjects.BehaviorSubject
import okhttp3.*
import ru.silcomsoft.mvprx_1.domain.model.GithubUser
import java.io.IOException

class GithubUsersRepo {
    private val repositories =
        (0..100).map { GithubUser("user$it") }

    private val bs = BehaviorSubject.create<List<GithubUser>>()
    fun getUsers(): List<GithubUser> {
        client
            .newCall(Request.Builder().url("https://api.github.com/users").build())
            .enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                println("fail")
            }

            override fun onResponse(call: Call, response: Response) {
                response.body
            }

        })
        return repositories
    }

    val client = OkHttpClient.Builder().build()
}