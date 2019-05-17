package com.rafakob.bitwarden.startup.passwordhint

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rafakob.bitwarden.base.BaseBottomSheetFragment
import com.rafakob.bitwarden.startup.R
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_password_hint, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onViewAttached()
        email.setText(arguments?.getString(EXTRA_EMAIL))
        send.setOnClickListener { dismiss() }
    }

    override fun onDestroyView() {
        presenter.onViewDetached()
        super.onDestroyView()
    }


}