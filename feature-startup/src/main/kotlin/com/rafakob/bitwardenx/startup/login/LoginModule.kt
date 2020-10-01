package com.rafakob.bitwardenx.startup.login

import com.rafakob.bitwardenx.scope.FragmentScope
import dagger.Binds
import dagger.Module

@Module
internal abstract class LoginModule {

    @Binds
    @FragmentScope
    abstract fun bindsView(view: LoginFragment): LoginContract.View

    @Binds
    @FragmentScope
    abstract fun bindsPresenter(presenter: LoginPresenter): LoginContract.Presenter
}