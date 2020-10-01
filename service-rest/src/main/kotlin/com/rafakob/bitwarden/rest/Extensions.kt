package com.rafakob.bitwarden.rest

import com.rafakob.bitwarden.rest.result.RestError
import io.reactivex.Single
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

fun <T> Single<T>.mapErrorToResult(function: (restError: RestError) -> T): Single<T> {
    return onErrorReturn { error ->
        val restError = when (error) {
            is SocketTimeoutException,
            is UnknownHostException -> RestError.ConnectionError()
            is HttpException -> RestError.ApiError(error.response()?.errorBody()?.string())
            else -> RestError.UnknownError()
        }

        function.invoke(restError)
    }
}
