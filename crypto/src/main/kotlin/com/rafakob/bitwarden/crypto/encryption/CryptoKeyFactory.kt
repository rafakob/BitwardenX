package com.rafakob.bitwarden.crypto.encryption

import com.rafakob.bitwarden.crypto.CryptoKey

interface CryptoKeyFactory {
    fun create(rawBytes: ByteArray, encryptionType: EncryptionType? = null): CryptoKey
}