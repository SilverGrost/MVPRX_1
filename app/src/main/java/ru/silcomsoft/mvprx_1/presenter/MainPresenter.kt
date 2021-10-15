package ru.silcomsoft.mvprx_1.presenter

import moxy.MvpPresenter
import ru.silcomsoft.mvprx_1.model.CountersModel
import ru.silcomsoft.mvprx_1.view.IMainView

class MainPresenter(private val model: CountersModel): MvpPresenter<IMainView>() {

    fun setButtonText1() {
        val nextValue = model.next(0)
        viewState.setButtonText1(nextValue.toString())
    }

    fun setButtonText2() {
        val nextValue = model.next(1)
        viewState.setButtonText2(nextValue.toString())
    }

    fun setButtonText3() {
        val nextValue = model.next(2)
        viewState.setButtonText3(nextValue.toString())
    }
}

