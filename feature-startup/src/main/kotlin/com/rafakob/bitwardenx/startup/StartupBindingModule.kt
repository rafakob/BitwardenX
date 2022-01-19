package com.rafakob.bitwardenx.startup

import com.rafakob.bitwardenx.scope.ActivityScope
import com.rafakob.bitwardenx.startup.startup.StartupActivity
import com.rafakob.bitwardenx.startup.startup.StartupModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class StartupBindingModule {

    @ContributesAndroidInjector(modules = [StartupModule::class])
    @ActivityScope
    abstract fun contributesStartup(): StartupActivity
}