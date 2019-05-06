package com.rafakob.bitwarden

import com.rafakob.bitwarden.access.AccessModule
import com.rafakob.bitwarden.crypto.CryptoModule
import com.rafakob.bitwarden.environment.EnvironmentModule
import com.rafakob.bitwarden.scope.AppScope
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@AppScope
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        CryptoModule::class,
        EnvironmentModule::class,
        AccessModule::class
    ]
)
interface AppComponent : AndroidInjector<BitwardenApplication> {
    @Component.Factory
    interface Factory : AndroidInjector.Factory<BitwardenApplication>
}