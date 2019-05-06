package com.rafakob.bitwarden.access

import androidx.fragment.app.FragmentManager
import com.rafakob.bitwarden.access.navigator.AccessNavigator
import javax.inject.Inject

class AccessAdapter @Inject constructor(
    private val accessNavigator: AccessNavigator
) : AccessPort {

    override fun initAccessView(fragmentManager: FragmentManager, containerResId: Int) {
        accessNavigator.init(fragmentManager, containerResId)
        accessNavigator.showStartup()
    }
}