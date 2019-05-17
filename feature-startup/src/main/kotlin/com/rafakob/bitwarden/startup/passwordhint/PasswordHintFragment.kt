package com.rafakob.bitwarden.startup.passwordhint

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.rafakob.bitwarden.base.BaseBottomSheetFragment
import com.rafakob.bitwarden.base.BaseFragment
import com.rafakob.bitwarden.startup.R
import javax.inject.Inject

internal class PasswordHintFragment : BaseBottomSheetFragment(), PasswordHintContract.View {

    @Inject
    lateinit var presenter: PasswordHintContract.Presenter

    companion object {
        fun newInstance() = PasswordHintFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_password_hint, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onViewAttached()
    }

    override fun onDestroyView() {
        presenter.onViewDetached()
        super.onDestroyView()
    }
}