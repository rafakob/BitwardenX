package com.rafakob.bitwarden.startup.login

import javax.inject.Inject

class EmailValidator @Inject constructor() {

    fun isValid(text: String) =
            text.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(text).matches()
}