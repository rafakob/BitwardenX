package com.rafakob.bitwardenx.startup.passwordhint

import com.rafakob.bitwardenx.rest.result.PasswordHintResult
import com.rafakob.bitwardenx.startup.R
import com.rafakob.bitwardenx.startup.login.EmailValidator
import io.reactivex.rxkotlin.withLatestFrom
import java.util.concurrent.TimeUnit
import javax.inject.Inject

internal class PasswordHintPresenter @Inject constructor(
        private val view: PasswordHintContract.View,
        private val passwordHintUseCase: PasswordHintUseCase,
        private val emailValidator: EmailValidator,
) : PasswordHintContract.Presenter() {

    override fun onViewAttached() {
        super.onViewAttached()
        view.sendClicked()
                .doOnNext {
                    view.setEmailEnabled(false)
                    view.setError(null)
                }
                .debounce(300, TimeUnit.MILLISECONDS)
                .withLatestFrom(emailChanges())
                .flatMapSingle { passwordHintUseCase.execute(PasswordHintUseCase.Params(it.second)) }
                .subscribe({ onSendResult(it) }, { it.printStackTrace() })
                .addToDisposables()

    }

    private fun onSendResult(result: PasswordHintResult) {
        when (result) {
            PasswordHintResult.Success -> {
                view.showSuccessPopup(R.string.passwordhint_success)
                view.close()
            }
            is PasswordHintResult.Failure -> {
                view.setError(error = result.reason)
                view.setSendEnabled(true)
                view.setEmailEnabled(true)
                view.stopLoading()
            }
        }
    }

    private fun emailChanges() =
            view.emailChanged()
                    .doOnNext {
                        if (emailValidator.isValid(it)) {
                            view.setSendEnabled(true)
                            view.setError(error = null)
                        } else {
                            view.setSendEnabled(false)

                            if (it.isEmpty()) {
                                view.setError(null)
                            } else {
                                view.setError(R.string.passwordhint_email_error)
                            }
                        }
                    }
}