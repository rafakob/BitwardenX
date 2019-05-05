package com.rafakob.bitwarden.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.rafakob.bitwarden.R
import kotlinx.android.synthetic.main.fragment_home.*

class ItemFragment : Fragment() {

    companion object {
        fun newInstance() = ItemFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_item, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }
}