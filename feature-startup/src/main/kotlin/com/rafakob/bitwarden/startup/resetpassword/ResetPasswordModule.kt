package com.rafakob.bitwarden.startup.resetpassword

import com.rafakob.bitwarden.scope.FragmentScope
import dagger.Binds
import dagger.Module

@Module
internal abstract class ResetPasswordModule {

    @Binds
    @FragmentScope
    abstract fun bindsView(view: ResetPasswordFragment): ResetPasswordContract.View

    @Binds
    @FragmentScope
    abstract fun bindsPresenter(presenter: ResetPasswordPresenter): ResetPasswordContract.Presenter
}