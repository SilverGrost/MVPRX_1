package ru.silcomsoft.mvprx_1.presenter

import ru.silcomsoft.mvprx_1.view.IMainView
import ru.silcomsoft.mvprx_1.model.CountersModel

class MainPresenter(private val viewI: IMainView) {
    private val model = CountersModel()

    //Архитектурная ошибка. В качестве практического задания -- исправить
    fun counterClick(type: CounterType) {
        val dataFromModel = when (type) {
            CounterType.FIRST -> model.next(0)
            CounterType.SECOND -> model.next(1)
            CounterType.THIRD -> model.next(2)
        }
        viewI.setButtonText(type, dataFromModel.toString())
    }
}

enum class CounterType {
    FIRST,
    SECOND,
    THIRD
}