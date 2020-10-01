package com.rafakob.bitwardenx.startup

import com.rafakob.bitwardenx.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class StartupBindingModule {

    @ContributesAndroidInjector(modules = [StartupModule::class])
    @ActivityScope
    abstract fun contributesStartup(): StartupActivity
}