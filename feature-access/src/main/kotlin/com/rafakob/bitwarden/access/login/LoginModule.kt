package com.rafakob.bitwarden.access.login

import com.rafakob.bitwarden.access.register.RegisterContract
import com.rafakob.bitwarden.access.register.RegisterFragment
import com.rafakob.bitwarden.access.register.RegisterPresenter
import com.rafakob.bitwarden.scope.FragmentScope
import dagger.Binds
import dagger.Module

@Module
abstract class LoginModule {

    @Binds
    @FragmentScope
    abstract fun bindsView(view: LoginFragment): LoginContract.View

    @Binds
    @FragmentScope
    abstract fun bindsPresenter(presenter: LoginPresenter): LoginContract.Presenter
}