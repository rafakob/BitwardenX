package com.rafakob.bitwardenx.environment

import javax.inject.Inject

class EnvironmentService @Inject constructor() : EnvironmentApi {
    
    override fun isDebuggable() = BuildConfig.DEBUG
}