package com.rafakob.bitwarden

import android.os.Bundle
import at.favre.lib.crypto.HKDF
import com.rafakob.bitwarden.crypto.CryptoApi
import com.rafakob.bitwarden.crypto.encryption.DefaultCryptoKeyFactory
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

        // User's data (passwordnever leaves device)
        val password = "12345678"
        val email = "test@punto.com"

        // User's master key (never leaves device)
        val masterKey = cryptoApi.makeKeyFromPassword(password, email, KdfType.PBKDF2_SHA256, 100_000)

        // Protected key returned from server (decrypt it using masterKey)
        val protectedKeyEncrypted =
            "2.upfqDMgWC/9r2R1xZ6yFOg==|0dXfp4jCgMgHE4zp/GwuNGW1AxsA3YIwM0kP6X6zafKIvrpntU4IOEYplZ99nwtGOP8oKvErP7aQ6q0Qs/X0lHUw4+5QPNZr/nWsw13kwXc=|lCQpgOtsRBtfydTsjG2mVHyFgky3iRSI6bKPv0lIujk="

        println("Crypto - masterKey: ${masterKey.b64Key}")


        val encKey = HKDF.fromHmacSha256().expand(masterKey.key, "enc".toByteArray(), 32)
        val macKey = HKDF.fromHmacSha256().expand(masterKey.key, "mac".toByteArray(), 32)
        val newKey = DefaultCryptoKeyFactory().create(encKey.plus(macKey))

        val protectedKey = cryptoApi.decrypt(protectedKeyEncrypted, newKey)
        println("Crypto - protectedKey: $protectedKey")

        val b = DefaultCryptoKeyFactory().create(Base64.decode(protectedKey))
        val text = cryptoApi.decrypt("2.o3lgExOggxaYy22aoxofnA==|l7cYUeR4cD69e31KB9Q8sg==|y7Kf+G7U75I64zsGQKJARqAhs0/ufTmbCg/eizpqJ8I=", b)


        println(String(Base64.decode(text)))


//        println(cryptoApi.decrypt("2.nmBz4AUiS+N9/gAgilSwnA==|Izp+vk+F5qgx2lXmWJ2oZQ==|NCyXVZO83/tsuJaRiXq7CaLSkNU3cI5zmqAK96kPwtg=", masterKey))

//           masterKey = makeKey("12345678","test@punto.com",100000)
//    protectedMasterKey = makeEncKey(masterKey)  # only for register
//    puts Base64.strict_encode64(masterKey)
//
//    # full master key: mBzm9uMhbY4aJ6JpN2T5XPGIUb3v9uobWnuQcSHfcDR9m/hAKTpI+3mg5oT7+oXP2uJqQzjh197E6h4N7te13Q==
//
//    key = decrypt("2.OHe/lIk86E/SdF7sqxjgZA==|kXtiPjY5qzDW39hEND8uCg==|tmpeL3S1KbEXVK64HUMMoye+xqMxYzdfrsZ3x9jJTsA=", Base64.decode64("mBzm9uMhbY4aJ6JpN2T5XPGIUb3v9uobWnuQcSHfcDQ="))
//    puts key
//    # puts decrypt("2.o3lgExOggxaYy22aoxofnA==|l7cYUeR4cD69e31KB9Q8sg==|y7Kf+G7U75I64zsGQKJARqAhs0/ufTmbCg/eizpqJ8I=", Base64.decode64(key))
    }
}
