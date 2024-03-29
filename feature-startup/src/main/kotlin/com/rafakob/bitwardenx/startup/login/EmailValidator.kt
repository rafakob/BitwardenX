package com.rafakob.bitwardenx.startup.login

import javax.inject.Inject

internal class EmailValidator @Inject constructor() {

    fun isValid(text: String) =
            text.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(text).matches()
}