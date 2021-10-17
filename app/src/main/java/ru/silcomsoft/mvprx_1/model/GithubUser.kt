package ru.silcomsoft.mvprx_1.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubUser(
    val login: String,
    val pass: String
): Parcelable


