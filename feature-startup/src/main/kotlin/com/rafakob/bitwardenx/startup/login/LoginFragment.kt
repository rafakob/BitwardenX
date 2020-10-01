package com.rafakob.bitwardenx.startup.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rafakob.bitwardenx.base.BaseFragment
import com.rafakob.bitwardenx.base.Navigator
import com.rafakob.bitwardenx.startup.R
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

internal class LoginFragment : BaseFragment(), LoginContract.View {

    @Inject
    lateinit var presenter: LoginContract.Presenter

    @Inject
    lateinit var navigator: Navigator

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onViewAttached()
        login.setOnClickListener { presenter.onLoginClick(getEmailString(), getPasswordString()) }
        register.setOnClickListener { presenter.onRegisterClick() }
        passwordHint.setOnClickListener { presenter.onPasswordHintClick(getEmailString()) }
//        register.makeGone()
//        passwordHint.makeGone()
    }

    override fun onDestroyView() {
        presenter.onViewDetached()
        super.onDestroyView()
    }

    override fun startMain() = navigator.startMain(activity!!)

    private fun getEmailString() = email?.editText?.text.toString()

    private fun getPasswordString() = password?.editText?.text.toString()
}