package com.rafakob.bitwarden

import com.rafakob.bitwarden.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ContributesAndroidInjector
    @ActivityScope
    abstract fun contributesMainActivity(): MainActivity
}