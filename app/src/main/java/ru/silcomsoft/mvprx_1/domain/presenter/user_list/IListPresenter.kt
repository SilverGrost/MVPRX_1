package ru.silcomsoft.mvprx_1.domain.presenter.user_list

import ru.silcomsoft.mvprx_1.view.IItemView

interface IListPresenter<V: IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}