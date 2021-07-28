package com.example.aztecatest.model.api

import com.example.aztecatest.model.data.Personajes
import com.example.aztecatest.model.response.PersonasResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    fun getPersonajes(
        @Url url: String
    ): Call<PersonasResponse<List<Personajes>>>
}