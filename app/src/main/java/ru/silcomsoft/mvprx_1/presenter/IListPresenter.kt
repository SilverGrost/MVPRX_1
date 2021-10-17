package ru.silcomsoft.mvprx_1.presenter

import ru.silcomsoft.mvprx_1.view.IItemView

interface IListPresenter<V: IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}