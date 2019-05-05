package com.rafakob.bitwarden.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.rafakob.bitwarden.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Toast.makeText(context,findNavController().currentDestination?.label, Toast.LENGTH_SHORT).show()

        if (UserStatus.isAutheticated.not()) {
            findNavController().navigate(R.id.action_homeFragment_to_login_graph)
            return
        }

        button.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_itemFragment)
        }
    }
}