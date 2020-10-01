package com.rafakob.bitwardenx.startup.navigator

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.rafakob.bitwardenx.base.BaseActivity
import com.rafakob.bitwardenx.startup.R
import com.rafakob.bitwardenx.startup.login.LoginFragment
import com.rafakob.bitwardenx.startup.passwordhint.PasswordHintFragment
import com.rafakob.bitwardenx.startup.register.RegisterFragment
import javax.inject.Inject

internal class AndroidStartupNavigator @Inject constructor(
    private val activity: BaseActivity
) : StartupNavigator {

    override fun showLogin() {
        replace(LoginFragment.newInstance(), false)
    }

    override fun showRegister() {
        replace(RegisterFragment.newInstance(), true)
    }

    override fun showPasswordHint(email: String) {
        PasswordHintFragment.newInstance(email)
            .show(activity.supportFragmentManager, PasswordHintFragment.TAG)
    }

    private fun replace(fragment: Fragment, addToBackStack: Boolean) {
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .apply {
                if (addToBackStack) addToBackStack(null)
            }
            .commit()
    }
}