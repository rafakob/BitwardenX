package com.rafakob.bitwardenx.crypto.encryption

import com.rafakob.bitwardenx.crypto.CryptoKey

interface CryptoKeyFactory {
    fun create(rawBytes: ByteArray, encryptionType: EncryptionType? = null): CryptoKey
}