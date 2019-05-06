package com.rafakob.bitwarden.access

import androidx.fragment.app.FragmentManager

interface AccessContainer {
    fun replaceInAccessContainer()
    fun accessFragmentManager(): FragmentManager
    fun accessViewContainer(): Int
}