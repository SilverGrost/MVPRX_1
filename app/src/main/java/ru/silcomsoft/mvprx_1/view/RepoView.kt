package ru.silcomsoft.mvprx_1.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface RepoView: MvpView {
    fun setRepoName(repoName: String)
}