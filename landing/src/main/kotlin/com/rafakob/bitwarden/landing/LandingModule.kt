package com.rafakob.bitwarden.landing

import com.rafakob.bitwarden.scope.ActivityScope
import com.rafakob.bitwarden.scope.FragmentScope
import dagger.Binds
import dagger.Module

@Module
abstract class LandingModule {

    @Binds
    @FragmentScope
    abstract fun bindsView(view: LandingFragment): LandingContract.View

    @Binds
    @FragmentScope
    abstract fun bindsPresenter(presenter: LandingPresenter): LandingContract.Presenter
}