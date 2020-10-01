package com.rafakob.bitwardenx.startup.login

import com.rafakob.bitwardenx.rest.result.LoginResult
import com.rafakob.bitwardenx.startup.navigator.StartupNavigator
import io.reactivex.Flowable
import io.reactivex.rxkotlin.Flowables
import io.reactivex.rxkotlin.withLatestFrom
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class LoginPresenter @Inject constructor(
        private val view: LoginContract.View,
        private val startupNavigator: StartupNavigator,
        private val loginUseCase: LoginUseCase,
        private val emailValidator: EmailValidator
) : LoginContract.Presenter() {

    override fun onViewAttached() {
        super.onViewAttached()

        view.registerClicked()
                .subscribe { startupNavigator.showRegister() }
                .addToDisposables()

        view.passwordHintClicked()
                .withLatestFrom(view.emailChanged())
                .subscribe { startupNavigator.showPasswordHint(it.second.trim()) }
                .addToDisposables()

        view.loginClicked()
                .doOnNext {
                    view.setEmailEnabled(false)
                    view.setPasswordEnabled(false)
                    view.setEmailError(null)
                }
                .debounce(300, TimeUnit.MILLISECONDS)
                .withLatestFrom(formChanges())
                .flatMapSingle { loginUseCase.execute(LoginUseCase.Params(it.second.email, it.second.password)) }
                .subscribe({ onLoginResult(it) }, { it.printStackTrace() })
                .addToDisposables()
    }

    private fun onLoginResult(result: LoginResult) {
        when (result) {
            LoginResult.Success -> {
                view.startMain()
            }
            is LoginResult.Failure -> {
                view.setEmailError(error = result.reason)
                view.setEmailEnabled(true)
                view.setPasswordEnabled(true)
                view.setLoginEnabled(true)
                view.stopLoading()
            }
        }
    }

    private fun formChanges(): Flowable<Form> {
        return Flowables.combineLatest(view.emailChanged(), view.passwordChanged())
                .doOnNext {
                    val isFormValid = validateEmail(it.first) && validatePassword(it.second)
                    view.setLoginEnabled(isFormValid)
                }
                .map { Form(it.first, it.second) }
    }

    private fun validateEmail(email: String) =
            if (emailValidator.isValid(email) || email.isEmpty()) {
                view.setEmailError(error = null)
                true
            } else {
                false
            }

    private fun validatePassword(password: String) =
            password.isNotBlank()

    data class Form(
            val email: String,
            val password: String,
    )
}