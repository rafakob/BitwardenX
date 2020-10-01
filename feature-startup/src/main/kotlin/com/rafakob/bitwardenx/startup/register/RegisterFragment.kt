package com.rafakob.bitwardenx.startup.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rafakob.bitwardenx.base.BaseFragment
import com.rafakob.bitwardenx.startup.R
import kotlinx.android.synthetic.main.fragment_register.*
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
        appBar.setToolbarTitle(R.string.register_toolbar_title)
        appBar.setToolbarButton(activity, R.drawable.ic_close)
        presenter.onViewAttached()
    }

    override fun onDestroyView() {
        presenter.onViewDetached()
        super.onDestroyView()
    }
}