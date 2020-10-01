package com.rafakob.bitwardenx.main

import com.rafakob.bitwardenx.scope.ActivityScope
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