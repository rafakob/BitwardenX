package com.rafakob.bitwarden.access.navigator

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.rafakob.bitwarden.access.login.LoginFragment
import com.rafakob.bitwarden.access.register.RegisterFragment
import com.rafakob.bitwarden.access.startup.StartupFragment
import com.rafakob.bitwarden.scope.ActivityScope
import javax.inject.Inject

@ActivityScope
class AccessNavigatorImpl @Inject constructor() : AccessNavigator {

    private var fragmentManager: FragmentManager? = null
    private var containerResId: Int = 0

    override fun init(fragmentManager: FragmentManager, containerResId: Int) {
        this.fragmentManager = fragmentManager
        this.containerResId = containerResId
    }

    override fun showStartup() = replace(StartupFragment.newInstance())

    override fun showLogin() = replace(LoginFragment.newInstance())

    override fun showRegister() = replace(RegisterFragment.newInstance())

    private fun replace(fragment: Fragment) {
        fragmentManager!!.let {
            it.beginTransaction()
                .replace(containerResId, fragment)
                .commit()
        }
    }
}