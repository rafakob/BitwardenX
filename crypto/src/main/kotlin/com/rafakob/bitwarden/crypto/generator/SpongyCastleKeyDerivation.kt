package com.rafakob.bitwarden.crypto.generator

import org.spongycastle.crypto.digests.SHA256Digest
import org.spongycastle.crypto.generators.PKCS5S2ParametersGenerator
import org.spongycastle.crypto.params.KeyParameter

class SpongyCastleKeyDerivation : KeyDerivation {

    companion object {
        private const val KEY_LENGTH = 256
    }

    override fun deriveKey(password: String, salt: String, iterations: Int): ByteArray {
        val generator = PKCS5S2ParametersGenerator(SHA256Digest()).apply { }
        generator.init(password.toByteArray(Charsets.UTF_8), salt.toByteArray(Charsets.UTF_8), iterations)

        return (generator.generateDerivedMacParameters(KEY_LENGTH) as KeyParameter).key
    }
}