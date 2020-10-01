package com.rafakob.bitwardenx.crypto.kdf

interface KeyDerivation {
    fun deriveKey(password: String, salt: String, type: KdfType, iterations: Int): ByteArray
}