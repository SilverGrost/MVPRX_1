package ru.silcomsoft.mvprx_1.model

class GithubUsersRepo {
    private val repositories =
        (0..100).map {GithubUser("user$it", "pass$it")}

    fun getUsers(): List<GithubUser> {
        return repositories
    }
}