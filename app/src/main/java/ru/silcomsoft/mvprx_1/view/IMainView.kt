package ru.silcomsoft.mvprx_1.view

import ru.silcomsoft.mvprx_1.presenter.CounterType

interface IMainView {
    fun setButtonText(type: CounterType, text: String)
}

