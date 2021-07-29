package com.example.aztecatest.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aztecatest.model.api.ApiService
import com.example.aztecatest.model.data.Personajes
import com.example.aztecatest.model.repository.implentation.PersonajeRepository
import com.example.aztecatest.model.repository.interfaces.IPersonajeRepository
import com.example.aztecatest.model.response.PersonasResponse
import com.example.aztecatest.ui.state.PersonasStateEvent
import com.example.aztecatest.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class PersonasViewModel
@Inject
constructor(
    private val personajeRepository: IPersonajeRepository
): ViewModel(){
    private val _personaResponse = MutableLiveData<DataState<PersonasResponse<List<Personajes>>>>()
    val personasResponse: LiveData<DataState<PersonasResponse<List<Personajes>>>> get() = _personaResponse


    fun makeApicall(personasStateEvent: PersonasStateEvent){
        when (personasStateEvent){
            is PersonasStateEvent.GetPersonajes ->{
                viewModelScope.launch {
                    personajeRepository.getPersonasjes(
                        personasStateEvent.url
                    ).collect{
                        _personaResponse.value = it
                    }
                }
            }
        }
    /*fun makeApicall(){
        val call: Call<PersonasResponse<List<Personajes>>> = apiService.getPersonajes("")
        call.enqueue(object : Callback<PersonasResponse<List<Personajes>>>{
            override fun onResponse(
                call: Call<PersonasResponse<List<Personajes>>>,
                response: Response<PersonasResponse<List<Personajes>>>
            ){
                if (response.isSuccessful){
                    _personaResponse.value = response.body()
                }else{
                    Log.e("AztecaTest", "error en respuesta")
                }
            }

            override fun onFailure(call: Call<PersonasResponse<List<Personajes>>>, t: Throwable) {
                Log.e("AztecaTest", "error en respuesta")
            }
        })*/


    }
}