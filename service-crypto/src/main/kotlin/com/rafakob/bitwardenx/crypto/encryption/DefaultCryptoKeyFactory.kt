package com.rafakob.bitwardenx.crypto.encryption

import com.rafakob.bitwardenx.crypto.CryptoKey
import com.rafakob.bitwardenx.crypto.exceptions.InvalidEncryptionType
import org.spongycastle.util.encoders.Base64

internal class DefaultCryptoKeyFactory : CryptoKeyFactory {

    override fun create(rawBytes: ByteArray, encryptionType: EncryptionType?): CryptoKey {

        val encType = encryptionType ?: when (rawBytes.size) {
            32 -> EncryptionType.AesCbc256_B64
            64 -> EncryptionType.AesCbc256_HmacSha256_B64
            else -> throw InvalidEncryptionType()
        }

        if (encType == EncryptionType.AesCbc256_B64 && rawBytes.size == 32) {
            return CryptoKey(
                key = rawBytes,
                encType = encType,
                encKey = rawBytes,
                macKey = null,
                b64Key = base64(rawBytes)
            )
        }

        if (encType == EncryptionType.AesCbc128_HmacSha256_B64 && rawBytes.size == 32) {
            return CryptoKey(
                key = rawBytes,
                encType = encType,
                encKey = rawBytes.take(16).toByteArray(),
                macKey = rawBytes.takeLast(16).toByteArray(),
                b64Key = base64(rawBytes)
            )
        }

        if (encType == EncryptionType.AesCbc256_HmacSha256_B64 && rawBytes.size == 64) {
            return CryptoKey(
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