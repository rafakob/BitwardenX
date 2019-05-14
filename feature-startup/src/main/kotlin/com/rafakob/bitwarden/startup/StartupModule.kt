package com.rafakob.bitwarden.startup

import com.rafakob.bitwarden.base.BaseActivity
import com.rafakob.bitwarden.scope.ActivityScope
import com.rafakob.bitwarden.startup.navigator.AndroidStartupNavigator
import com.rafakob.bitwarden.startup.navigator.StartupNavigator
import dagger.Binds
import dagger.Module

@Module
internal abstract class StartupModule {

    @Binds
    @ActivityScope
    abstract fun bindsView(view: StartupActivity): StartupContract.View

    @Binds
    @ActivityScope
    abstract fun bindsPresenter(presenter: StartupPresenter): StartupContract.Presenter

    @Binds
    @ActivityScope
    abstract fun bindsActivity(activity: StartupActivity): BaseActivity

    @Binds
    @ActivityScope
    abstract fun bindsNavigator(androidAccessNavigator: AndroidStartupNavigator): StartupNavigator
}