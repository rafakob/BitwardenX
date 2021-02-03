package com.rafakob.bitwardenx.crypto

import com.rafakob.bitwardenx.crypto.kdf.KdfType

interface CryptoApi {
    fun makeKeyFromPassword(password: String, email: String, kdfType: KdfType, kdfIterations: Int): CryptoKey
    fun hashPassword(symmetricCryptoKey: CryptoKey, password: String): ByteArray
    fun hashPasswordBase64(symmetricCryptoKey: CryptoKey, password: String): String
}