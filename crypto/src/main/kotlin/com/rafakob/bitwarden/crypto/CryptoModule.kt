package com.rafakob.bitwarden.crypto

import com.rafakob.bitwarden.crypto.encryption.SymmetricCryptoKeyFactory
import com.rafakob.bitwarden.crypto.kdf.SpongyCastleKeyDerivation
import com.rafakob.bitwarden.scope.AppScope
import dagger.Module
import dagger.Provides

@Module
class CryptoModule {

    @Provides
    @AppScope
    fun providesCryptoApi(): CryptoApi = CryptoService(SpongyCastleKeyDerivation(), SymmetricCryptoKeyFactory())
}