package com.example.aztecatest.model.data

import com.squareup.moshi.Json

data class Result(
    @Json(name ="info")
    var info: Info? = null,
    @Json(name ="results")
    var result: List<Personajes> = ArrayList()
)