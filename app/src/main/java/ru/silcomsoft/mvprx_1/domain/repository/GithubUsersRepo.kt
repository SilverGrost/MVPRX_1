package ru.silcomsoft.mvprx_1.domain.repository

import ru.silcomsoft.mvprx_1.domain.model.GithubUser

class GithubUsersRepo {
    private val repositories =
        (0..100).map { GithubUser("user$it") }

    fun getUsers(): List<GithubUser> {
        return repositories
    }
}