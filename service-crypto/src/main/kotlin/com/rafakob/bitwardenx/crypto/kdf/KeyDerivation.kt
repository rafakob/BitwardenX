package com.rafakob.bitwardenx.crypto.kdf

interface KeyDerivation {
    fun deriveKey(password: ByteArray, salt: String, type: KdfType, iterations: Int): ByteArray
}