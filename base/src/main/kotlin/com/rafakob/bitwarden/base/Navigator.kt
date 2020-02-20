package com.rafakob.bitwarden.base

import android.content.Context

interface Navigator {
    fun startSplash(context: Context)
    fun startLogin(context: Context)
    fun startMain(context: Context)
}