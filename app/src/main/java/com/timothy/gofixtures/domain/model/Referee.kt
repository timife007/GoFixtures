package com.timothy.gofixtures.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Referee (
    val id : Int,
    val name : String
        ):Parcelable