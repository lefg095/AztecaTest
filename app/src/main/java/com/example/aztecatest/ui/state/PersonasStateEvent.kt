package com.example.aztecatest.ui.state

sealed class PersonasStateEvent {
    data class GetPersonajes(
        val url: String
    ): PersonasStateEvent()
}