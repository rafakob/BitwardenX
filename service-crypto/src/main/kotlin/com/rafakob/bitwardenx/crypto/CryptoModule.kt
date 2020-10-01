package com.rafakob.bitwardenx.crypto

import com.rafakob.bitwardenx.crypto.encryption.DefaultCryptoKeyFactory
import com.rafakob.bitwardenx.crypto.kdf.SpongyCastleKeyDerivation
import com.rafakob.bitwardenx.scope.AppScope
import dagger.Module
import dagger.Provides

@Module
class CryptoModule {

    @Provides
    @AppScope
    fun providesCryptoApi(): CryptoApi = CryptoService(SpongyCastleKeyDerivation(), DefaultCryptoKeyFactory())
}