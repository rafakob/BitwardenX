package com.rafakob.bitwardenx.startup.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding3.view.clicks
import com.jakewharton.rxbinding3.widget.textChanges
import com.rafakob.bitwardenx.base.BaseFragment
import com.rafakob.bitwardenx.base.Navigator
import com.rafakob.bitwardenx.startup.R
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
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
    }

    override fun onDestroyView() {
        presenter.onViewDetached()
        super.onDestroyView()
    }

    override fun emailChanged(): Flowable<String> =
            email.textChanges().map { it.toString() }.toFlowable(BackpressureStrategy.LATEST)

    override fun passwordChanged(): Flowable<String> =
            password.textChanges().map { it.toString() }.toFlowable(BackpressureStrategy.LATEST)

    override fun loginClicked(): Flowable<Unit> =
            login.clicks().toFlowable(BackpressureStrategy.LATEST)

    override fun registerClicked(): Flowable<Unit> =
            register.clicks().toFlowable(BackpressureStrategy.LATEST)

    override fun passwordHintClicked(): Flowable<Unit> =
            passwordHint.clicks().toFlowable(BackpressureStrategy.LATEST)

    override fun setEmailEnabled(enabled: Boolean) {
        emailInput.isEnabled = enabled
    }

    override fun setPasswordEnabled(enabled: Boolean) {
        passwordInput.isEnabled = enabled
    }

    override fun setLoginEnabled(enabled: Boolean) {
        login.isEnabled = enabled
    }

    override fun setEmailError(errorRes: Int?, error: String?) {
        emailInput.error = error ?: errorRes?.let { getString(it) }
    }

    override fun stopLoading() {
        login.showNormal()
    }

    override fun startMain() {
        navigator.startMain(requireActivity())
        requireActivity().finish()
    }
}