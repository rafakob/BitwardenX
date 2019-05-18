package com.rafakob.bitwarden.rest.body

import com.google.gson.annotations.SerializedName

internal data class PreLoginBody(
    @SerializedName("email")
    val email: String
)