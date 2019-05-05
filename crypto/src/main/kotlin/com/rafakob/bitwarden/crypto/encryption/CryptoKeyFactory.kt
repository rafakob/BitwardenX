package com.rafakob.bitwarden.crypto.encryption

import com.rafakob.bitwarden.crypto.SymmetricCryptoKey

interface CryptoKeyFactory {
    fun create(rawBytes: ByteArray, encryptionType: EncryptionType? = null): SymmetricCryptoKey
}