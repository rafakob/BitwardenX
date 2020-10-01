package com.rafakob.bitwardenx.rest.result

import com.rafakob.bitwardenx.rest.R


sealed class RestError(val msgRes: Int?, val errorBody: String? = null) {

    class ConnectionError : RestError(msgRes = R.string.connection_error)
    class UnknownError : RestError(msgRes = R.string.unknown_error)
    class ApiError(errorBody: String?) : RestError(null, errorBody)
}