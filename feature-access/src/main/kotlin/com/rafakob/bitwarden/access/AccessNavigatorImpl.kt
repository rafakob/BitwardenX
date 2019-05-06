package com.rafakob.bitwarden.access

import androidx.fragment.app.Fragment
import com.rafakob.bitwarden.access.AccessContainer
import com.rafakob.bitwarden.access.AccessNavigator
import com.rafakob.bitwarden.access.login.LoginFragment
import com.rafakob.bitwarden.access.register.RegisterFragment
import com.rafakob.bitwarden.access.startup.StartupFragment
import javax.inject.Inject

class AccessNavigatorImpl @Inject constructor(
    private val accessContainer: AccessContainer
) : AccessNavigator {

    override fun showStartup() = replace(StartupFragment.newInstance())

    override fun showLogin() = replace(LoginFragment.newInstance())

    override fun showRegister() = replace(RegisterFragment.newInstance())

    private fun replace(fragment: Fragment) {
        accessContainer.accessFragmentManager().beginTransaction()
            .replace(accessContainer.accessViewContainer(), fragment)
            .commit()
    }
}