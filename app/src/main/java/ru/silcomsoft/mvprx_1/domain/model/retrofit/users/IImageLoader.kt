package ru.silcomsoft.mvprx_1.domain.model.retrofit.users

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}