package org.example.todotask.util

sealed class RequestState<out T> {
    data object Idle : RequestState<Nothing>()
    data object Loading : RequestState<Nothing>()
    data class Success<T>(var data:T): RequestState<T>()
    data class Failure(var e:Throwable): RequestState<Nothing>()
}