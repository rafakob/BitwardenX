package com.rafakob.bitwarden.crypto.kdf

interface KeyDerivation {
    fun deriveKey(
        password: ByteArray,
        salt: ByteArray,
        iterations: Int,
        type: KdfType = KdfType.PBKDF2_SHA256
    ): ByteArray
}