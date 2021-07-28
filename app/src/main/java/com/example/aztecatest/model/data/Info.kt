package com.example.aztecatest.model.data

import com.squareup.moshi.Json

data class Info(
    @Json(name="count")
    var count: String =  "",
    @Json(name="pages")
    var pages: String= "",
    @Json(name="next")
    var nex: String = "",
    @Json(name="prev")
    var prev: String? = ""
)