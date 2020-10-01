package com.rafakob.bitwardenx.startup.passwordhint

import com.rafakob.bitwardenx.base.BasePresenter
import io.reactivex.Flowable

internal interface PasswordHintContract {
    interface View {
        fun emailChanged(): Flowable<String>
        fun sendClicked(): Flowable<Unit>

        fun setSendEnabled(enabled: Boolean)
        fun setEmailEnabled(enabled: Boolean)
        fun setError(errorRes: Int? = null, error: String? = null)
        fun showSuccessPopup(msgRes: Int)
        fun close()
        fun stopLoading()
    }

    abstract class Presenter : BasePresenter()
}