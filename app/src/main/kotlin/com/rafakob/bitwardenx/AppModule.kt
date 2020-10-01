package com.rafakob.bitwardenx

import com.rafakob.bitwardenx.base.Navigator
import com.rafakob.bitwardenx.main.MainActivity
import com.rafakob.bitwardenx.main.MainModule
import com.rafakob.bitwardenx.scope.ActivityScope
import com.rafakob.bitwardenx.scope.AppScope
import com.rafakob.bitwardenx.splash.SplashActivity
import com.rafakob.bitwardenx.splash.SplashModule
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