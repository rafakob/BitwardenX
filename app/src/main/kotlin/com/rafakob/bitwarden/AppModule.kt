package com.rafakob.bitwarden

import com.rafakob.bitwarden.access.AccessContainer
import com.rafakob.bitwarden.scope.ActivityScope
import com.rafakob.bitwarden.scope.AppScope
import com.rafakob.bitwarden.splash.SplashActivity
import com.rafakob.bitwarden.splash.SplashModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ContributesAndroidInjector
    @ActivityScope
    abstract fun contributesMain(): MainActivity

    @ContributesAndroidInjector(modules = [SplashModule::class])
    @ActivityScope
    abstract fun contributesSplash(): SplashActivity

    @Binds
    @AppScope
    abstract fun contributesSasdplash(mainActivity: MainActivity): AccessContainer

//    @ContributesAndroidInjector(modules = [LandingModule::class])
//    @FragmentScope
//    abstract fun contributesLanding(): LandingFragment
}