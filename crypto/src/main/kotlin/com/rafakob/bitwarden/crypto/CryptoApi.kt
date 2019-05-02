package com.rafakob.bitwarden.crypto

import com.rafakob.bitwarden.crypto.kdf.KdfType

interface CryptoApi {
    fun makeKeyFromPassword(password: String, email: String, kdfType: KdfType, kdfIterations: Int): CryptoKey
}