package com.rafakob.bitwardenx.crypto

import com.rafakob.bitwardenx.crypto.kdf.KdfType

interface CryptoApi {
    fun makeKeyFromPassword(password: String, email: String, kdfType: KdfType, kdfIterations: Int): CryptoKey
}