package com.example.aztecatest.model.api

import com.example.aztecatest.model.data.Personajes
import com.example.aztecatest.model.response.PersonasResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET("character/")
    suspend fun getPersonajes(
    ): PersonasResponse<List<Personajes>>
}