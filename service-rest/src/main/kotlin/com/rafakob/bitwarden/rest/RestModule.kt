package com.rafakob.bitwarden.rest

import com.rafakob.bitwarden.rest.api.*
import com.rafakob.bitwarden.scope.AppScope
import dagger.Binds
import dagger.Module

@Module
abstract class RestModule {

    @Binds
    @AppScope
    abstract fun bindsBitwardenApi(bitwardenService: BitwardenService): BitwardenApi

    @Binds
    @AppScope
    abstract fun bindsIdentityApi(identityService: IdentityService): IdentityApi

    @Binds
    @AppScope
    abstract fun bindsVaultnApi(vaultService: VaultService): VaultApi
}