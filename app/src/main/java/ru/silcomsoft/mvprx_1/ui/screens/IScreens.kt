package ru.silcomsoft.mvprx_1.ui.screens

import com.github.terrakok.cicerone.Screen
import ru.silcomsoft.mvprx_1.domain.model.GithubUser

interface IScreens {
    fun userList(): Screen
    fun userDetail(user: GithubUser): Screen
}

