package com.rafakob.bitwarden.startup.passwordhint

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rafakob.bitwarden.base.BaseFragment
import com.rafakob.bitwarden.startup.R
import javax.inject.Inject

internal class PasswordHintFragment : BaseFragment(), PasswordHintContract.View {

    @Inject
    lateinit var presenter: PasswordHintContract.Presenter

    companion object {
        fun newInstance() = PasswordHintFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_reset_password, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onViewAttached()
    }

    override fun onDestroyView() {
        presenter.onViewDetached()
        super.onDestroyView()
    }
}