package com.rafakob.bitwarden.rest

import com.rafakob.bitwarden.scope.AppScope
import dagger.Binds
import dagger.Module

@Module
abstract class RestModule {

    @Binds
    @AppScope
    abstract fun bindsApi(restService: RestService): RestApi
}