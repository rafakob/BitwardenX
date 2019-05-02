package com.rafakob.bitwarden.crypto.generator

interface KeyDerivation {
    fun deriveKey(password: String, salt: String, iterations: Int): ByteArray
}