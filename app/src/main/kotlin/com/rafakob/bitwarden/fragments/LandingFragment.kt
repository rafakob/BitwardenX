package com.rafakob.bitwarden.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rafakob.bitwarden.R
import kotlinx.android.synthetic.main.fragment_landing.*

class LandingFragment : Fragment() {

    companion object {
        fun newInstance() = LandingFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_landing, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        login.setOnClickListener { findNavController().navigate(R.id.action_landingFragment_to_loginFragment) }
        register.setOnClickListener { findNavController().navigate(R.id.action_landingFragment_to_registerFragment) }
    }
}