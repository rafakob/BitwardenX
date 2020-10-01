package com.rafakob.bitwardenx.environment

import com.rafakob.bitwardenx.scope.AppScope
import dagger.Binds
import dagger.Module

@Module
abstract class EnvironmentModule {

    @Binds
    @AppScope
    abstract fun bindsApi(environmentService: EnvironmentService): EnvironmentApi
}