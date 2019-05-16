package com.rafakob.bitwarden.startup

import com.rafakob.bitwarden.scope.ActivityScope
import com.rafakob.bitwarden.scope.FragmentScope
import com.rafakob.bitwarden.startup.login.LoginFragment
import com.rafakob.bitwarden.startup.login.LoginModule
import com.rafakob.bitwarden.startup.register.RegisterFragment
import com.rafakob.bitwarden.startup.register.RegisterModule
import com.rafakob.bitwarden.startup.resetpassword.ResetPasswordFragment
import com.rafakob.bitwarden.startup.resetpassword.ResetPasswordModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class StartupBindingModule {

    @ContributesAndroidInjector(modules = [StartupModule::class])
    @ActivityScope
    abstract fun contributesStartup(): StartupActivity
}