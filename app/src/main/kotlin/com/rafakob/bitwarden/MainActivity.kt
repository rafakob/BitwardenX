package com.rafakob.bitwarden

import android.os.Bundle
import at.favre.lib.crypto.HKDF
import com.rafakob.bitwarden.crypto.CryptoApi
import com.rafakob.bitwarden.crypto.encryption.SymmetricCryptoKeyFactory
import com.rafakob.bitwarden.crypto.kdf.KdfType
import dagger.android.support.DaggerAppCompatActivity
import org.spongycastle.util.encoders.Base64
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var cryptoApi: CryptoApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Plain password (never leaves device)
        val password = "12345678"
        // Plain email (salt for PBKDF2)
        val email = "test@punto.com"

        // Private key (never leaves device)
        val privateKey = cryptoApi.makeKeyFromPassword(password, email, KdfType.PBKDF2_SHA256, 100_000)
        println("Crypto - privateKey: ${privateKey.b64Key}")

        // Public key returned from server (decrypt it using privateKey)
        val publicKeyEncrypted = "2.upfqDMgWC/9r2R1xZ6yFOg==|0dXfp4jCgMgHE4zp/GwuNGW1AxsA3YIwM0kP6X6zafKIvrpntU4IOEYplZ99nwtGOP8oKvErP7aQ6q0Qs/X0lHUw4+5QPNZr/nWsw13kwXc=|lCQpgOtsRBtfydTsjG2mVHyFgky3iRSI6bKPv0lIujk="

        // Stretch privateKey to encKey and macKey using HKDF
        val encKey = HKDF.fromHmacSha256().expand(privateKey.key, "enc".toByteArray(), 32)
        val macKey = HKDF.fromHmacSha256().expand(privateKey.key, "mac".toByteArray(), 32)
        val stretchedPrivateKey = SymmetricCryptoKeyFactory().create(encKey.plus(macKey))

        // Decrypt public key with stretchedPrivateKey
        val publicKey = cryptoApi.decrypt(publicKeyEncrypted, stretchedPrivateKey) // b64 string
        println("Crypto - publicKey: $publicKey")

        // Create symmetric key from public key
        val symmetricDecryptionKey = SymmetricCryptoKeyFactory().create(Base64.decode(publicKey))

        // Text to decrypt (eg. "reddit.com")
        val textEncrypted = "2.o3lgExOggxaYy22aoxofnA==|l7cYUeR4cD69e31KB9Q8sg==|y7Kf+G7U75I64zsGQKJARqAhs0/ufTmbCg/eizpqJ8I="
        val text = cryptoApi.decrypt(textEncrypted, symmetricDecryptionKey)

        println("Crypto - text: ${String(Base64.decode(text))}")
    }
}
