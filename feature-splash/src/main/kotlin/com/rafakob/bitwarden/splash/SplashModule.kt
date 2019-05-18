package com.rafakob.bitwarden.splash

import com.rafakob.bitwarden.scope.ActivityScope
import dagger.Binds
import dagger.Module

@Module
abstract class SplashModule {

    @Binds
    @ActivityScope
    abstract fun bindsView(view: SplashActivity): SplashContract.View

    @Binds
    @ActivityScope
    abstract fun bindsPresenter(presenter: SplashPresenter): SplashContract.Presenter
}