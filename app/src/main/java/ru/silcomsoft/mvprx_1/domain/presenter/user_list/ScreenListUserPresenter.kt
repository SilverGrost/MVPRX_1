package ru.silcomsoft.mvprx_1.domain.presenter.user_list

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.silcomsoft.mvprx_1.domain.model.retrofit.users.IGithubUsersRepo
import ru.silcomsoft.mvprx_1.ui.screens.IScreens
import ru.silcomsoft.mvprx_1.view.IUserListView

class ScreenUserListPresenter(
    private val uiScheduler: Scheduler,
    private val usersRepo: IGithubUsersRepo,
    private val router: Router,
    private val screens: IScreens
) : MvpPresenter<IUserListView>() {

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { itemView ->
            val user = usersListPresenter.users[itemView.pos]
            router.navigateTo(screens.userDetail(user))
        }
    }

    private fun loadData() {
        usersRepo.getUsers()
            .observeOn(uiScheduler)
            .subscribe({ repos ->
                usersListPresenter.users.clear()
                usersListPresenter.users.addAll(repos)
                viewState.updateList()
            }, {
                println("Error: ${it.message}")
            })
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }



}
