package com.rafakob.bitwarden.startup.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rafakob.bitwarden.base.BaseFragment
import com.rafakob.bitwarden.startup.R
import com.rafakob.bitwarden.startup.navigator.StartupNavigator
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

internal class LoginFragment : BaseFragment(), LoginContract.View {

    @Inject
    lateinit var presenter: LoginContract.Presenter

    @Inject
    lateinit var navigator: StartupNavigator

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onViewAttached()
        register.setOnClickListener { navigator.showRegister() }
        passwordHint.setOnClickListener { navigator.showPasswordHint(email?.editText?.text.toString()) }
    }

    override fun onDestroyView() {
        presenter.onViewDetached()
        super.onDestroyView()
    }
}