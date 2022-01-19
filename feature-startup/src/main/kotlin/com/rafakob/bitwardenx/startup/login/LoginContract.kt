package com.rafakob.bitwardenx.startup.login

import com.rafakob.bitwardenx.base.BasePresenter
import io.reactivex.Flowable

internal interface LoginContract {
    interface View {
        fun emailChanged(): Flowable<String>
        fun passwordChanged(): Flowable<String>
        fun loginClicked(): Flowable<Unit>
        fun registerClicked(): Flowable<Unit>
        fun passwordHintClicked(): Flowable<Unit>

        fun setEmailEnabled(enabled: Boolean)
        fun setPasswordEnabled(enabled: Boolean)
        fun setLoginEnabled(enabled: Boolean)
        fun setEmailError(errorRes: Int? = null, error: String? = null)
        fun stopLoading()
        fun startMain()
    }

    abstract class Presenter : BasePresenter()
}