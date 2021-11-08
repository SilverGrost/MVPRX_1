package ru.silcomsoft.mvprx_1.domain.presenter.repo

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.silcomsoft.mvprx_1.domain.model.GithubRepository
import ru.silcomsoft.mvprx_1.view.RepoView

class RepoPresenter(
    private val router: Router,
    private val repo: GithubRepository
) : MvpPresenter<RepoView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        repo.name?.let { viewState.setRepoName(it) }
    }

    private val compositeDisposable = CompositeDisposable()

    fun backClick(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}