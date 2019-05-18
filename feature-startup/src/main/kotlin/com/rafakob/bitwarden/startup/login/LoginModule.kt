package com.rafakob.bitwarden.startup.login

import com.rafakob.bitwarden.scope.FragmentScope
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