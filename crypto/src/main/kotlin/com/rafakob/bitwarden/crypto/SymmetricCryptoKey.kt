package com.rafakob.bitwarden.crypto

import com.rafakob.bitwarden.crypto.encryption.EncryptionType

data class SymmetricCryptoKey(
    val key: ByteArray,
    val encType: EncryptionType,
    val encKey: ByteArray,
    val macKey: ByteArray?,
    val b64Key: String
)