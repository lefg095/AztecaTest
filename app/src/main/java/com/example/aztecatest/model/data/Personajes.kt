package com.example.aztecatest.model.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Personajes(
    @Json(name="id")
    var id: String= "",
    @Json(name="name")
    var name: String= "",
    @Json(name="status")
    var status: String= "",
    @Json(name="species")
    var species: String= "",
    @Json(name="type")
    var type: String= "",
    @Json(name="gender")
    var gender: String= "",
    @Json(name="origin")
    var origin: Origin? = null,
    @Json(name="location")
    var location: Location? = null,
    @Json(name="image")
    var image: String= "",
    @Json(name="episode")
    var episode: List<String> = ArrayList(),
    @Json(name="url")
    var url: String= "",
    @Json(name="created")
    var created: String= ""
): Parcelable