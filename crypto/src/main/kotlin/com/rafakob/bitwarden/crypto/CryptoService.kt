package com.rafakob.bitwarden.crypto

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import com.rafakob.bitwarden.crypto.encryption.CryptoKeyFactory
import com.rafakob.bitwarden.crypto.kdf.KdfType
import com.rafakob.bitwarden.crypto.kdf.KeyDerivation
import org.spongycastle.util.encoders.Base64
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class CryptoService(
    private val keyDerivation: KeyDerivation,
    private val cryptoKeyFactory: CryptoKeyFactory
) : CryptoApi {

    override fun decrypt(text: String, cryptoKey: CryptoKey): String {
        val (iv, ct, mac) = text.removePrefix("2.").split("|")

        val ivB = decodeBase64(iv)
        val ctB = decodeBase64(ct)
        val macB = decodeBase64(mac)


//        # decrypt a CipherString and return plaintext
//        def decrypt(str, key, macKey)
//        if str[0].to_i != 2
//        raise "implement #{str[0].to_i} decryption"
//        end
//
//        # AesCbc256_HmacSha256_B64
//        iv, ct, mac = str[2 .. -1].split("|", 3)
//
//        iv = Base64.decode64(iv)
//        ct = Base64.decode64(ct)
//        mac = Base64.decode64(mac)
//
//        cmac = OpenSSL::HMAC.digest(OpenSSL::Digest.new("SHA256"), macKey, iv + ct)
//        if !macsEqual(macKey, mac, cmac)
//        raise "invalid mac"
//        end
//
//        cipher = OpenSSL::Cipher.new "AES-256-CBC"
//        cipher.decrypt
//        cipher.iv = iv
//        cipher.key = key
//        pt = cipher.update(ct)
//        pt << cipher.final
//                pt
//        end


        val cipher = Cipher.getInstance("AES/CBC/PKCS7Padding")
        cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(cryptoKey.encKey, "AES/CBC/PKCS7Padding"), IvParameterSpec(ivB))


        return encodeBase64(cipher.doFinal(ctB))

    }

    override fun makeKeyFromPassword(password: String, email: String, kdfType: KdfType, kdfIterations: Int): CryptoKey {
        val keyBytes =
            keyDerivation.deriveKey(
                password = normalizePassword(password).toByteArray(),
                salt = normalizeEmail(email).toByteArray(),
                iterations = kdfIterations,
                type = kdfType
            )

        return cryptoKeyFactory.create(keyBytes)
    }

    override fun hashPassword(cryptoKey: CryptoKey, password: String) =
        keyDerivation.deriveKey(
            password = cryptoKey.key,
            salt = normalizePassword(password).toByteArray(),
            iterations = 1
        )

    override fun hashPasswordBase64(cryptoKey: CryptoKey, password: String) =
        encodeBase64(hashPassword(cryptoKey, password))

    private fun normalizeEmail(email: String) = email.trim().toLowerCase()

    private fun normalizePassword(password: String) =
        password
            .replace("\r\n", " ")
            .replace("\n", " ")
            .replace(" ", " ")


    private fun encodeBase64(key: ByteArray) = Base64.toBase64String(key)
    private fun decodeBase64(key: String) = Base64.decode(key)
}