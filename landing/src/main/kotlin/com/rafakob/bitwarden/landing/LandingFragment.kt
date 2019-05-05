package com.rafakob.bitwarden.landing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rafakob.bitwarden.base.BaseFragment
import javax.inject.Inject

class LandingFragment : BaseFragment(), LandingContract.View {

    @Inject
    lateinit var presenter: LandingContract.Presenter

    companion object {
        fun newInstance() = LandingFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_landing, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onViewAttached()
    }

    override fun onDestroyView() {
        presenter.onViewDetached()
        super.onDestroyView()
    }
}