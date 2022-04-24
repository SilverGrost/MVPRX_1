package ru.silcomsoft.mvprx_1.domain.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubRepository (
    @Expose val id: String? = null,
    @Expose val name: String? = null,
    @Expose val forksCount: Int? = null
): Parcelable