package com.rafakob.bitwarden.crypto.encryption

import com.rafakob.bitwarden.crypto.SymmetricCryptoKey
import com.rafakob.bitwarden.crypto.exceptions.InvalidEncryptionType
import org.spongycastle.util.encoders.Base64

class SymmetricCryptoKeyFactory : CryptoKeyFactory {

    override fun create(rawBytes: ByteArray, encryptionType: EncryptionType?): SymmetricCryptoKey {

        val encType = encryptionType ?: when (rawBytes.size) {
            32 -> EncryptionType.AesCbc256_B64
            64 -> EncryptionType.AesCbc256_HmacSha256_B64
            else -> throw InvalidEncryptionType()
        }

        if (encType == EncryptionType.AesCbc256_B64 && rawBytes.size == 32) {
            return SymmetricCryptoKey(
                key = rawBytes,
                encType = encType,
                encKey = rawBytes,
                macKey = null,
                b64Key = base64(rawBytes)
            )
        }

        if (encType == EncryptionType.AesCbc128_HmacSha256_B64 && rawBytes.size == 32) {
            return SymmetricCryptoKey(
                key = rawBytes,
                encType = encType,
                encKey = rawBytes.take(16).toByteArray(),
                macKey = rawBytes.takeLast(16).toByteArray(),
                b64Key = base64(rawBytes)
            )
        }

        if (encType == EncryptionType.AesCbc256_HmacSha256_B64 && rawBytes.size == 64) {
            return SymmetricCryptoKey(
                key = rawBytes,
                encType = encType,
                encKey = rawBytes.take(32).toByteArray(),
                macKey = rawBytes.takeLast(32).toByteArray(),
                b64Key = base64(rawBytes)
            )
        }

        throw InvalidEncryptionType()
    }

    private fun base64(key: ByteArray) = Base64.toBase64String(key)
}