package com.rafakob.bitwardenx.rest.result

sealed class LoginResult {
    object Success : LoginResult()
    data class Failure(val reason: String) : LoginResult()
}