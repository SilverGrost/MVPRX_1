package ru.silcomsoft.mvprx_1.domain.presenter.user_list

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter
import ru.silcomsoft.mvprx_1.domain.model.GithubUser
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
        Data().makeLoadData()
        viewState.updateList()

        userListPresenter.itemClickListener = { itemView ->
            val user = userListPresenter.users[itemView.pos]
            router.navigateTo(screens.userDetail(user))
        }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    inner class Data {
        fun makeLoadData() = Consumer(Producer()).execFromIterable()
    }

    inner class Producer {
        fun fromIterable(): Observable<GithubUser> =
            Observable.fromIterable(githubUsersRepository.getUsers())
    }

    inner class Consumer(private val producer: Producer) {
        private val githubUserObserver = object : Observer<GithubUser> {
            var disposable: Disposable? = null

            override fun onSubscribe(disposableOnSubscribe: Disposable?) {
                disposable = disposableOnSubscribe
                println("onSubscribe")
            }

            override fun onNext(githubUser: GithubUser?) {
                println("onNext: $githubUser")
                githubUser?.let { userListPresenter.users.add(it) }
            }

            override fun onError(throwable: Throwable?) {
                println("onError: ${throwable?.message}")
            }

            override fun onComplete() {
                println("onComplete")
            }
        }

        fun execFromIterable() {
            producer.fromIterable().subscribe(githubUserObserver)
        }
    }


}
