package ru.silcomsoft.mvprx_1.ui.screens

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.silcomsoft.mvprx_1.domain.model.GithubUser
import ru.silcomsoft.mvprx_1.ui.fragment.UserListFragment
import ru.silcomsoft.mvprx_1.ui.fragment.UserDetailsFragment

class Screens: IScreens {
    override fun userList(): Screen {
        return FragmentScreen { UserListFragment.newInstance() }
    }

    override fun userDetail(user: GithubUser): Screen {
        return FragmentScreen { UserDetailsFragment.newInstance(user) }
    }

}