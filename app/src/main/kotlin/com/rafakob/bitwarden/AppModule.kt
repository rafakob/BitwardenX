package com.rafakob.bitwarden

import com.rafakob.bitwarden.access.AccessModule
import com.rafakob.bitwarden.main.MainActivity
import com.rafakob.bitwarden.main.MainModule
import com.rafakob.bitwarden.scope.ActivityScope
import com.rafakob.bitwarden.splash.SplashActivity
import com.rafakob.bitwarden.splash.SplashModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ContributesAndroidInjector(modules = [MainModule::class, AccessModule::class])
    @ActivityScope
    abstract fun contributesMain(): MainActivity

    @ContributesAndroidInjector(modules = [SplashModule::class])
    @ActivityScope
    abstract fun contributesSplash(): SplashActivity
}