package com.example.aztecatest.model.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Origin(
    @Json(name="name")
    var name: String= "",
    @Json(name="url")
    var url: String= ""
): Parcelable