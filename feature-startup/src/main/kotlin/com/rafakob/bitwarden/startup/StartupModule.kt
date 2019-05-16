package com.rafakob.bitwarden.startup

import com.rafakob.bitwarden.base.BaseActivity
import com.rafakob.bitwarden.scope.ActivityScope
import com.rafakob.bitwarden.scope.FragmentScope
import com.rafakob.bitwarden.startup.login.LoginFragment
import com.rafakob.bitwarden.startup.login.LoginModule
import com.rafakob.bitwarden.startup.navigator.AndroidStartupNavigator
import com.rafakob.bitwarden.startup.navigator.StartupNavigator
import com.rafakob.bitwarden.startup.register.RegisterFragment
import com.rafakob.bitwarden.startup.register.RegisterModule
import com.rafakob.bitwarden.startup.resetpassword.ResetPasswordFragment
import com.rafakob.bitwarden.startup.resetpassword.ResetPasswordModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class StartupModule {

    @ContributesAndroidInjector(modules = [LoginModule::class])
    @FragmentScope
    abstract fun contributesLogin(): LoginFragment

    @ContributesAndroidInjector(modules = [RegisterModule::class])
    @FragmentScope
    abstract fun contributesRegister(): RegisterFragment

    @ContributesAndroidInjector(modules = [ResetPasswordModule::class])
    @FragmentScope
    abstract fun contributesResetPassword(): ResetPasswordFragment

    @Binds
    @ActivityScope
    abstract fun bindsView(view: StartupActivity): StartupContract.View

    @Binds
    @ActivityScope
    abstract fun bindsPresenter(presenter: StartupPresenter): StartupContract.Presenter

    @Binds
    @ActivityScope
    abstract fun bindsActivity(activity: StartupActivity): BaseActivity

    @Binds
    @ActivityScope
    abstract fun bindsNavigator(androidAccessNavigator: AndroidStartupNavigator): StartupNavigator
}