package ru.silcomsoft.mvprx_1.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IListUsersView: MvpView {
    fun init()
    fun updateList()
}