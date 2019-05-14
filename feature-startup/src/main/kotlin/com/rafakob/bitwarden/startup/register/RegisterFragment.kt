package com.rafakob.bitwarden.startup.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rafakob.bitwarden.base.BaseFragment
import com.rafakob.bitwarden.startup.R
import javax.inject.Inject

internal class RegisterFragment : BaseFragment(), RegisterContract.View {

    @Inject
    lateinit var presenter: RegisterContract.Presenter

    companion object {
        fun newInstance() = RegisterFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_register, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onViewAttached()
    }

    override fun onDestroyView() {
        presenter.onViewDetached()
        super.onDestroyView()
    }
}