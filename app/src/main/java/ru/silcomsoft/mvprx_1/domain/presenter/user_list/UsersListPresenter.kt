package ru.silcomsoft.mvprx_1.domain.presenter.user_list

import ru.silcomsoft.mvprx_1.domain.model.GithubUser
import ru.silcomsoft.mvprx_1.view.IUserItemView

class UsersListPresenter : IUserListPresenter {

    val users = mutableListOf<GithubUser>()

    override var itemClickListener: ((IUserItemView) -> Unit)? = null

    override fun getCount() = users.size

    override fun bindView(view: IUserItemView) {
        val user = users[view.pos]
        user.login.let { view.setLogin(it) }
        user.avatarUrl?.let {view.loadAvatar(it)}
    }
}