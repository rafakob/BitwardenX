package com.rafakob.bitwarden.access

import androidx.fragment.app.FragmentManager

interface AccessPort {
    fun initAccessView(fragmentManager: FragmentManager, containerResId: Int)
}