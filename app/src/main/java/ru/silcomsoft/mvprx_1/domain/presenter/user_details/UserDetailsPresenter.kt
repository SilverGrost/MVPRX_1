package ru.silcomsoft.mvprx_1.domain.presenter.user_details

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.silcomsoft.mvprx_1.domain.model.GithubRepository
import ru.silcomsoft.mvprx_1.domain.model.GithubUser
import ru.silcomsoft.mvprx_1.domain.model.retrofit.repos.IGithubReposByUser
import ru.silcomsoft.mvprx_1.domain.presenter.repo.IReposListPresenter
import ru.silcomsoft.mvprx_1.ui.screens.IScreens
import ru.silcomsoft.mvprx_1.ui.screens.Screens
import ru.silcomsoft.mvprx_1.view.IUserDetailsView
import ru.silcomsoft.mvprx_1.view.RepoItemView

class UserDetailsPresenter(
    private val router: Router,
    private val reposRepo: IGithubReposByUser,
    private val scheduler: Scheduler,
    private val screens: IScreens
) : MvpPresenter<IUserDetailsView>() {

    val reposListPresenter = ReposListPresenter()
    private val compositeDisposable = CompositeDisposable()
    var user: GithubUser? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()

        loadData()

        reposListPresenter.itemClickListener = { view ->
            router.navigateTo(screens.repoScreen(reposListPresenter.repos[view.pos]))
        }
    }

    private fun loadData() {
        /*viewState.showProgressBar()
        viewState.setLogin(user?.login)*/
        user?.let { it ->
            reposRepo.getRepositories(it/*.reposUrl*/)
                ?.observeOn(scheduler)
                ?.subscribe({
                    reposListPresenter.repos.clear()
                    reposListPresenter.repos.addAll(it)
                    /*viewState.updateReposList()
                    viewState.hideProgressBar()*/
                }, {
                    it.printStackTrace()
                })
                .addTo(compositeDisposable)
        }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    inner class ReposListPresenter : IReposListPresenter {
        override var itemClickListener: ((RepoItemView) -> Unit)? = null

        val repos = mutableListOf<GithubRepository>()

        override fun bindView(view: RepoItemView) {
            val repo = repos[view.pos]
            repo.name?.let { view.setRepositoryName(it) }
        }

        override fun getCount() = repos.size
    }
}