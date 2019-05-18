package com.rafakob.bitwarden.environment

import com.rafakob.bitwarden.scope.AppScope
import dagger.Binds
import dagger.Module

@Module
abstract class EnvironmentModule {

    @Binds
    @AppScope
    abstract fun bindsApi(environmentService: EnvironmentService): EnvironmentApi
}