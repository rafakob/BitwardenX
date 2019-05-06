package com.rafakob.bitwarden.access

import com.rafakob.bitwarden.access.login.LoginFragment
import com.rafakob.bitwarden.access.login.LoginModule
import com.rafakob.bitwarden.access.navigator.AccessNavigator
import com.rafakob.bitwarden.access.navigator.AccessNavigatorImpl
import com.rafakob.bitwarden.access.register.RegisterFragment
import com.rafakob.bitwarden.access.register.RegisterModule
import com.rafakob.bitwarden.access.startup.StartupFragment
import com.rafakob.bitwarden.access.startup.StartupModule
import com.rafakob.bitwarden.scope.ActivityScope
import com.rafakob.bitwarden.scope.FragmentScope
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AccessModule {

    @ContributesAndroidInjector(modules = [StartupModule::class])
    @FragmentScope
    abstract fun contributesStartup(): StartupFragment

    @ContributesAndroidInjector(modules = [LoginModule::class])
    @FragmentScope
    abstract fun contributesLogin(): LoginFragment

    @ContributesAndroidInjector(modules = [RegisterModule::class])
    @FragmentScope
    abstract fun contributesRegister(): RegisterFragment

    @Binds
    @ActivityScope
    abstract fun bindsNavigator(accessNavigatorImpl: AccessNavigatorImpl): AccessNavigator
}