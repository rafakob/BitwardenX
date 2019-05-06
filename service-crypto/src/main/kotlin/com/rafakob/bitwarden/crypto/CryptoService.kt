package com.rafakob.bitwarden.crypto

import com.rafakob.bitwarden.crypto.encryption.CryptoKeyFactory
import com.rafakob.bitwarden.crypto.kdf.KdfType
import com.rafakob.bitwarden.crypto.kdf.KeyDerivation

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