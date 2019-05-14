package com.rafakob.bitwarden.startup.navigator

import androidx.fragment.app.Fragment
import com.rafakob.bitwarden.base.BaseActivity
import com.rafakob.bitwarden.startup.R
import com.rafakob.bitwarden.startup.login.LoginFragment
import com.rafakob.bitwarden.startup.resetpassword.ResetPasswordFragment
import com.rafakob.bitwarden.startup.register.RegisterFragment
import javax.inject.Inject

internal class AndroidStartupNavigator @Inject constructor(
    private val activity: BaseActivity
) : StartupNavigator {

    override fun showLogin() {
        replace(LoginFragment.newInstance())
    }

    override fun showRegister() {
        replace(RegisterFragment.newInstance())
    }

    override fun showResetPassword() {
        replace(ResetPasswordFragment.newInstance())
    }

    private fun replace(fragment: Fragment) {
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}