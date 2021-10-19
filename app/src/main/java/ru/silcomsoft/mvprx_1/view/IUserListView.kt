package ru.silcomsoft.mvprx_1.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)

interface IUserListView: MvpView {
    fun init()
    fun updateList()
}