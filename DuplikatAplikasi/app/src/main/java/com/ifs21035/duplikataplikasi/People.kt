package com.ifs21035.duplikataplikasi

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class People(
    var name: String,
    var icon: Int,
    var job: String,
) :Parcelable