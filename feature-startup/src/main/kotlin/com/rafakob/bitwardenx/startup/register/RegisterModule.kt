package com.rafakob.bitwardenx.startup.register

import com.rafakob.bitwardenx.scope.FragmentScope
import dagger.Binds
import dagger.Module

@Module
internal abstract class RegisterModule {

    @Binds
    @FragmentScope
    abstract fun bindsView(view: RegisterFragment): RegisterContract.View

    @Binds
    @FragmentScope
    abstract fun bindsPresenter(presenter: RegisterPresenter): RegisterContract.Presenter
}