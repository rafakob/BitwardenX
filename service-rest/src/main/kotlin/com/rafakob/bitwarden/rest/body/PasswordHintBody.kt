package com.rafakob.bitwarden.rest.body

import com.google.gson.annotations.SerializedName

internal data class PasswordHintBody(
    @SerializedName("email")
    val email: String
)