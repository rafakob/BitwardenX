package com.rafakob.bitwarden

import com.rafakob.bitwarden.scope.ActivityScope
import com.rafakob.bitwarden.splash.SplashActivity
import com.rafakob.bitwarden.splash.SplashModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ContributesAndroidInjector
    @ActivityScope
    abstract fun contributesMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [SplashModule::class])
    @ActivityScope
    abstract fun contributesSplashActivity(): SplashActivity
}