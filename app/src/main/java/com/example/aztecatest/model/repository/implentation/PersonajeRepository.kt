package com.example.aztecatest.model.repository.implentation

import com.example.aztecatest.model.api.ApiService
import com.example.aztecatest.model.data.Personajes
import com.example.aztecatest.model.repository.interfaces.IPersonajeRepository
import com.example.aztecatest.model.response.PersonasResponse
import com.example.aztecatest.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PersonajeRepository(
    private val apiService: ApiService
) : IPersonajeRepository {

    override fun getPersonasjes(
        url: String
    ): Flow<DataState<PersonasResponse<List<Personajes>>>> = flow {
        emit(DataState.Loading("Cargando personajes..."))
        try{
            val response = apiService.getPersonajes(
                url
            )
            emit(DataState.Success(response))
        }catch (e:Exception){
            emit(DataState.Error(e))
        }
    }
}