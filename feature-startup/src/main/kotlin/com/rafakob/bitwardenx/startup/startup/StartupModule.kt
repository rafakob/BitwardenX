package com.rafakob.bitwardenx.startup.startup

import com.rafakob.bitwardenx.base.BaseActivity
import com.rafakob.bitwardenx.scope.ActivityScope
import com.rafakob.bitwardenx.scope.FragmentScope
import com.rafakob.bitwardenx.startup.login.LoginFragment
import com.rafakob.bitwardenx.startup.login.LoginModule
import com.rafakob.bitwardenx.startup.navigator.AndroidStartupNavigator
import com.rafakob.bitwardenx.startup.navigator.StartupNavigator
import com.rafakob.bitwardenx.startup.register.RegisterFragment
import com.rafakob.bitwardenx.startup.register.RegisterModule
import com.rafakob.bitwardenx.startup.passwordhint.PasswordHintFragment
import com.rafakob.bitwardenx.startup.passwordhint.PasswordHintModule
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

    @ContributesAndroidInjector(modules = [PasswordHintModule::class])
    @FragmentScope
    abstract fun contributesPasswordHint(): PasswordHintFragment

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