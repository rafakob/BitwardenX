package com.rafakob.bitwarden.startup

import com.rafakob.bitwarden.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class StartupBindingModule {

    @ContributesAndroidInjector(modules = [StartupModule::class])
    @ActivityScope
    abstract fun contributesStartup(): StartupActivity
}