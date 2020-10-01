package com.rafakob.bitwardenx.rest.result

sealed class PasswordHintResult {
    object Success : PasswordHintResult()
    data class Failure(val reason: String) : PasswordHintResult()
}