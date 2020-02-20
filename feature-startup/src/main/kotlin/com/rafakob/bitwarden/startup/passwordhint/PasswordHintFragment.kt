package com.rafakob.bitwarden.startup.passwordhint

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.jakewharton.rxbinding3.view.clicks
import com.jakewharton.rxbinding3.widget.textChanges
import com.rafakob.bitwarden.base.BaseBottomSheetFragment
import com.rafakob.bitwarden.startup.R
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import kotlinx.android.synthetic.main.fragment_password_hint.*
import javax.inject.Inject

internal class PasswordHintFragment : BaseBottomSheetFragment(), PasswordHintContract.View {

    @Inject
    lateinit var presenter: PasswordHintContract.Presenter

    companion object {
        private const val EXTRA_EMAIL = "email"

        val TAG: String = PasswordHintFragment::class.java.simpleName
        fun newInstance(email: String) = PasswordHintFragment().apply {
            arguments = Bundle().apply { putString(EXTRA_EMAIL, email) }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_password_hint, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onViewAttached()
        email.setText(arguments?.getString(EXTRA_EMAIL))
    }

    override fun onDestroyView() {
        presenter.onViewDetached()
        super.onDestroyView()
    }

    override fun emailChanged(): Flowable<String> = email.textChanges().map { it.toString() }.toFlowable(BackpressureStrategy.LATEST)

    override fun sendClicked(): Flowable<Unit> = send.clicks().toFlowable(BackpressureStrategy.LATEST)

    override fun setSendEnabled(enabled: Boolean) {
        send.isEnabled = enabled
    }

    override fun setError(errorRes: Int?, error: String?) {
        emailInput.error = error ?: errorRes?.let { getString(it) }
    }

    override fun setEmailEnabled(enabled: Boolean) {
        emailInput.isEnabled = enabled
    }

    override fun showSuccessPopup(msgRes: Int) {
        Toast.makeText(context!!, getString(msgRes), Toast.LENGTH_LONG).show()
    }

    override fun close() = dismiss()

    override fun stopLoading() = send.showNormal()
}