package com.rafakob.bitwardenx.rest

import com.rafakob.bitwardenx.rest.api.*
import com.rafakob.bitwardenx.scope.AppScope
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