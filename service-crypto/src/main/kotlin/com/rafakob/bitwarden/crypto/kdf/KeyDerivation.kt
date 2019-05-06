package com.rafakob.bitwarden.crypto.kdf

interface KeyDerivation {
    fun deriveKey(password: String, salt: String, type: KdfType, iterations: Int): ByteArray
}