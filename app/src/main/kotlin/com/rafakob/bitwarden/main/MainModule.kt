package com.rafakob.bitwarden.main

import com.rafakob.bitwarden.scope.ActivityScope
import dagger.Binds
import dagger.Module

@Module
abstract class MainModule {

    @Binds
    @ActivityScope
    abstract fun bindsView(view: MainActivity): MainContract.View

    @Binds
    @ActivityScope
    abstract fun bindsPresenter(presenter: MainPresenter): MainContract.Presenter
}