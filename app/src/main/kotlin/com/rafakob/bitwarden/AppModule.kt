package com.rafakob.bitwarden

import com.rafakob.bitwarden.base.Navigator
import com.rafakob.bitwarden.main.MainActivity
import com.rafakob.bitwarden.main.MainModule
import com.rafakob.bitwarden.scope.ActivityScope
import com.rafakob.bitwarden.scope.AppScope
import com.rafakob.bitwarden.splash.SplashActivity
import com.rafakob.bitwarden.splash.SplashModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @AppScope
    @Binds
    abstract fun bindsNavigator(appNavigator: AppNavigator): Navigator

    @ContributesAndroidInjector(modules = [MainModule::class])
    @ActivityScope
    abstract fun contributesMain(): MainActivity

    @ContributesAndroidInjector(modules = [SplashModule::class])
    @ActivityScope
    abstract fun contributesSplash(): SplashActivity
}