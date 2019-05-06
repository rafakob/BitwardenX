package com.rafakob.bitwarden.environment

import javax.inject.Inject

class EnvironmentService @Inject constructor() : EnvironmentApi {
    
    override fun isDebuggable() = BuildConfig.DEBUG
}