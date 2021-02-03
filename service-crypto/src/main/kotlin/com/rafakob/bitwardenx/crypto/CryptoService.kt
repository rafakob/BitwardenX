package com.rafakob.bitwardenx.crypto

import com.rafakob.bitwardenx.crypto.encryption.CryptoKeyFactory
import com.rafakob.bitwardenx.crypto.kdf.KdfType
import com.rafakob.bitwardenx.crypto.kdf.KeyDerivation
import org.spongycastle.util.encoders.Base64

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
                keyDerivation.deriveKey(password = password.toByteArray(), salt = email, type = kdfType, iterations = kdfIterations)

        return cryptoKeyFactory.create(keyBytes)
    }

    override fun hashPassword(symmetricCryptoKey: CryptoKey, password: String) =
            keyDerivation.deriveKey(
                    password = symmetricCryptoKey.key,
                    salt = normalizePassword(password),
                    type = KdfType.PBKDF2_SHA256,
                    iterations = 1
            )

    override fun hashPasswordBase64(symmetricCryptoKey: CryptoKey, password: String) =
            encodeBase64(hashPassword(symmetricCryptoKey, password))

    private fun normalizeEmail(email: String) = email.trim().toLowerCase()

    private fun normalizePassword(password: String) =
            password
                    .replace("\r\n", " ")
                    .replace("\n", " ")
                    .replace(" ", " ")


    private fun encodeBase64(key: ByteArray) = Base64.toBase64String(key)
    private fun decodeBase64(key: String) = Base64.decode(key)
}