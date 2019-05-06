package com.rafakob.bitwarden.access.startup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rafakob.bitwarden.access.R
import com.rafakob.bitwarden.base.BaseFragment
import javax.inject.Inject

class StartupFragment : BaseFragment(), StartupContract.View {

    @Inject
    lateinit var presenter: StartupContract.Presenter

    companion object {
        fun newInstance() = StartupFragment()
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