package com.rafakob.bitwardenx.crypto.kdf

import com.rafakob.bitwardenx.crypto.exceptions.InvalidKdfType
import org.spongycastle.crypto.digests.SHA256Digest
import org.spongycastle.crypto.generators.PKCS5S2ParametersGenerator
import org.spongycastle.crypto.params.KeyParameter

internal class SpongyCastleKeyDerivation : KeyDerivation {

    companion object {
        private const val KEY_LENGTH = 256
    }

    override fun deriveKey(password: String, salt: String, type: KdfType, iterations: Int): ByteArray {
        val generator = createGenerator(type)
        generator.init(password.toByteArray(Charsets.UTF_8), salt.toByteArray(Charsets.UTF_8), iterations)

        return (generator.generateDerivedMacParameters(KEY_LENGTH) as KeyParameter).key
    }

    private fun createGenerator(type: KdfType) =
        when (type) {
            KdfType.PBKDF2_SHA256 -> PKCS5S2ParametersGenerator(SHA256Digest())
            else -> throw InvalidKdfType()
        }
}