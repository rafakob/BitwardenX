package com.rafakob.bitwarden.access.startup

import com.rafakob.bitwarden.scope.FragmentScope
import dagger.Binds
import dagger.Module

@Module
abstract class StartupModule {

    @Binds
    @FragmentScope
    abstract fun bindsView(view: StartupFragment): StartupContract.View

    @Binds
    @FragmentScope
    abstract fun bindsPresenter(presenter: StartupPresenter): StartupContract.Presenter
}