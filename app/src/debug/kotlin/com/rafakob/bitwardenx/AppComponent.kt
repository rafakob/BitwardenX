package com.rafakob.bitwardenx

import android.content.Context
import com.rafakob.bitwardenx.crypto.CryptoModule
import com.rafakob.bitwardenx.environment.EnvironmentModule
import com.rafakob.bitwardenx.rest.NetworkModule
import com.rafakob.bitwardenx.rest.RestModule
import com.rafakob.bitwardenx.scope.AppScope
import com.rafakob.bitwardenx.startup.StartupBindingModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@AppScope
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            AppModule::class,
            CryptoModule::class,
            StartupBindingModule::class,
            EnvironmentModule::class,
            NetworkModule::class,
            RestModule::class
        ]
)
interface AppComponent : AndroidInjector<BitwardenApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}