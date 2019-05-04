package com.rafakob.bitwarden.crypto

import com.rafakob.bitwarden.crypto.kdf.KdfType

interface CryptoApi {
    fun decrypt(cipher: String, cryptoKey: CryptoKey): String
    fun makeKeyFromPassword(password: String, email: String, kdfType: KdfType, kdfIterations: Int): CryptoKey
    fun hashPassword(cryptoKey: CryptoKey, password: String): ByteArray
    fun hashPasswordBase64(cryptoKey: CryptoKey, password: String): String
}