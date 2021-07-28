package com.example.aztecatest.model.repository.interfaces

import com.example.aztecatest.model.data.Personajes
import com.example.aztecatest.model.response.PersonasResponse
import com.example.aztecatest.util.DataState
import kotlinx.coroutines.flow.Flow

interface IPersonajeRepository {
    fun getPersonasjes(url: String): Flow<DataState<PersonasResponse<List<Personajes>>>>
}