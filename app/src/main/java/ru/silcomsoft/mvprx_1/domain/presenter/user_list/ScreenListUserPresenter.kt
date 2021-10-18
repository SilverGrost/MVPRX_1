package ru.silcomsoft.mvprx_1.domain.presenter.user_list

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.silcomsoft.mvprx_1.domain.repository.GithubUsersRepo
import ru.silcomsoft.mvprx_1.ui.screens.IScreens
import ru.silcomsoft.mvprx_1.view.IUserListView

class ScreenUserListPresenter(
    private val githubUsersRepository: GithubUsersRepo,
    private val router: Router,
    private val screens: IScreens
) : MvpPresenter<IUserListView>() {

    val userListPresenter = UserListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        userListPresenter.itemClickListener = { itemView ->
            val user = userListPresenter.users[itemView.pos]
            router.navigateTo(screens.userDetail(user))
        }
    }

    private fun loadData() {
        val users = githubUsersRepository.getUsers()
        userListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}
