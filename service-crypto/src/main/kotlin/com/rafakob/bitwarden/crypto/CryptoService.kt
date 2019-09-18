package com.rafakob.bitwarden.crypto

import com.rafakob.bitwarden.crypto.encryption.CryptoKeyFactory
import com.rafakob.bitwarden.crypto.kdf.KdfType
import com.rafakob.bitwarden.crypto.kdf.KeyDerivation
import org.spongycastle.util.encoders.Base64
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class CryptoService(
    private val keyDerivation: KeyDerivation,
    private val cryptoKeyFactory: CryptoKeyFactory
) : CryptoApi {

    override fun decrypt(text: String, symmetricCryptoKey: SymmetricCryptoKey): String {
        val (iv, ct, mac) = text.removePrefix("2.").split("|")

        val ivB = decodeBase64(iv)
        val ctB = decodeBase64(ct)
        val macB = decodeBase64(mac)

        val cipher = Cipher.getInstance("AES/CBC/PKCS7Padding")
        cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(symmetricCryptoKey.encKey, "AES/CBC/PKCS7Padding"), IvParameterSpec(ivB))

        return encodeBase64(cipher.doFinal(ctB))

    }

    override fun makeKeyFromPassword(password: String, email: String, kdfType: KdfType, kdfIterations: Int): SymmetricCryptoKey {
        val keyBytes =
            keyDerivation.deriveKey(
                password = normalizePassword(password).toByteArray(),
                salt = normalizeEmail(email).toByteArray(),
                iterations = kdfIterations,
                type = kdfType
            )

        return cryptoKeyFactory.create(keyBytes)
    }

    override fun hashPassword(symmetricCryptoKey: SymmetricCryptoKey, password: String) =
        keyDerivation.deriveKey(
            password = symmetricCryptoKey.key,
            salt = normalizePassword(password).toByteArray(),
            iterations = 1
        )

    override fun hashPasswordBase64(symmetricCryptoKey: SymmetricCryptoKey, password: String) =
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