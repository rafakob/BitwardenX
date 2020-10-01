package com.rafakob.bitwardenx.crypto

import com.rafakob.bitwardenx.crypto.encryption.CryptoKeyFactory
import com.rafakob.bitwardenx.crypto.kdf.KdfType
import com.rafakob.bitwardenx.crypto.kdf.KeyDerivation

class CryptoService(
    private val keyDerivation: KeyDerivation,
    private val cryptoKeyFactory: CryptoKeyFactory
) : CryptoApi {

    override fun makeKeyFromPassword(
        password: String,
        email: String,
        kdfType: KdfType,
        kdfIterations: Int
    ): CryptoKey {

        // TODO: normalize email

        val keyBytes =
            keyDerivation.deriveKey(password = password, salt = email, type = kdfType, iterations = kdfIterations)

        return cryptoKeyFactory.create(keyBytes)
    }
}