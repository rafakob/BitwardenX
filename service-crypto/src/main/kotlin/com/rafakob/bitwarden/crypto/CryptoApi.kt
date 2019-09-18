package com.rafakob.bitwarden.crypto

import com.rafakob.bitwarden.crypto.kdf.KdfType

interface CryptoApi {
    fun decrypt(cipher: String, symmetricCryptoKey: SymmetricCryptoKey): String
    fun makeKeyFromPassword(password: String, email: String, kdfType: KdfType, kdfIterations: Int): SymmetricCryptoKey
    fun hashPassword(symmetricCryptoKey: SymmetricCryptoKey, password: String): ByteArray
    fun hashPasswordBase64(symmetricCryptoKey: SymmetricCryptoKey, password: String): String
}