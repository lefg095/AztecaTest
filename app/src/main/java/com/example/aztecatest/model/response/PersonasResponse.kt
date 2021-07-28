package com.example.aztecatest.model.response

import com.example.aztecatest.model.data.Info
import com.squareup.moshi.Json

data class PersonasResponse<T>(
    @Json(name = "info")
    var info: Info?,
    @Json(name = "results")
    val data: T?
)