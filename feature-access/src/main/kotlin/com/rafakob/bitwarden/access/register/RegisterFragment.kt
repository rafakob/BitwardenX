package com.rafakob.bitwarden.access.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rafakob.bitwarden.access.R
import com.rafakob.bitwarden.base.BaseFragment
import javax.inject.Inject

class RegisterFragment : BaseFragment(), RegisterContract.View {

    @Inject
    lateinit var presenter: RegisterContract.Presenter

    companion object {
        fun newInstance() = RegisterFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_startup, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onViewAttached()
    }

    override fun onDestroyView() {
        presenter.onViewDetached()
        super.onDestroyView()
    }
}