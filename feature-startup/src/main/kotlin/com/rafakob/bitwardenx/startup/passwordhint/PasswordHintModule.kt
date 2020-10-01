package com.rafakob.bitwardenx.startup.passwordhint

import com.rafakob.bitwardenx.scope.FragmentScope
import dagger.Binds
import dagger.Module

@Module
internal abstract class PasswordHintModule {

    @Binds
    @FragmentScope
    abstract fun bindsView(view: PasswordHintFragment): PasswordHintContract.View

    @Binds
    @FragmentScope
    abstract fun bindsPresenter(presenter: PasswordHintPresenter): PasswordHintContract.Presenter
}