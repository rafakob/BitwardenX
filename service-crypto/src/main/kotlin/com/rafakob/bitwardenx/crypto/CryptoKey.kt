package com.rafakob.bitwardenx.crypto

import com.rafakob.bitwardenx.crypto.encryption.EncryptionType

data class CryptoKey(
    val key: ByteArray,
    val encType: EncryptionType,
    val encKey: ByteArray,
    val macKey: ByteArray?,
    val b64Key: String
)