package ru.silcomsoft.mvprx_1.presenter

import moxy.MvpPresenter
import ru.silcomsoft.mvprx_1.model.GithubUser
import ru.silcomsoft.mvprx_1.model.GithubUsersRepo
import ru.silcomsoft.mvprx_1.view.IListUsersView
import ru.silcomsoft.mvprx_1.view.IUserItemView

class ScreenListUserPresenter(private val usersRepo: GithubUsersRepo): MvpPresenter<IListUsersView>(){
    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((IUserItemView) -> Unit)? = null
        override fun getCount() = users.size
        override fun bindView(view: IUserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }
    private val usersListPresenter = UsersListPresenter()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        usersListPresenter.itemClickListener = { itemView ->
            //TODO: переход на экран пользователя
        }
    }
    private fun loadData(){
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }
}