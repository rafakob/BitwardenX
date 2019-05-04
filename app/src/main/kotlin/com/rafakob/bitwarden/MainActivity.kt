package com.rafakob.bitwarden

import android.os.Bundle
import com.rafakob.bitwarden.crypto.CryptoApi
import com.rafakob.bitwarden.crypto.kdf.KdfType
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var cryptoApi: CryptoApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val masterPass = "12345678"
        val key = cryptoApi.makeKeyFromPassword(masterPass, "test@punto.com", KdfType.PBKDF2_SHA256, 100_000)
        val hashMasterPass = cryptoApi.hashPasswordBase64(key, masterPass)

        println("Crypto - MasterHashPass: $hashMasterPass") // TODO: send hashMasterPass to login request
        println("Crypto - MasterKey: ${key.b64Key}")

        println(cryptoApi.decrypt("2.nmBz4AUiS+N9/gAgilSwnA==|Izp+vk+F5qgx2lXmWJ2oZQ==|NCyXVZO83/tsuJaRiXq7CaLSkNU3cI5zmqAK96kPwtg=", key))
    }
}
