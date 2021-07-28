package com.example.aztecatest.util

sealed class DataState<out R> {
    data class Success<out T>(val response: T) : DataState<T>()
    data class Error(val error: Exception) : DataState<Nothing>()
    data class Loading(val message: String) : DataState<Nothing>()

}