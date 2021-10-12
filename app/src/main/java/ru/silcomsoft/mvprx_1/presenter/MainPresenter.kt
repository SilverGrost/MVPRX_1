package ru.silcomsoft.mvprx_1.presenter

import ru.silcomsoft.mvprx_1.view.IMainView
import ru.silcomsoft.mvprx_1.R
import ru.silcomsoft.mvprx_1.model.CountersModel

class MainPresenter(private val viewI: IMainView)  {
    private val model = CountersModel()

    //Архитектурная ошибка. В качестве практического задания -- исправить
    fun counterClick(type: CounterType){
        when(type){
            CounterType.FIRST -> {
                val nextValue = model.next(0)
                viewI.setButtonText(0, nextValue.toString())
            }
            CounterType.SECOND -> {
                val nextValue = model.next(1)
                viewI.setButtonText(1, nextValue.toString())
            }
            CounterType.THIRD -> {
                val nextValue = model.next(2)
                viewI.setButtonText(2, nextValue.toString())
            }
        }
    }

}

enum class CounterType {
    FIRST,
    SECOND,
    THIRD
}