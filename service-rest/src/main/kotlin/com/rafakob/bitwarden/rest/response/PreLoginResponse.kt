package com.rafakob.bitwarden.rest.response

import com.google.gson.annotations.SerializedName

internal data class PreLoginResponse(
    @SerializedName("Kdf")
    val kdf: Int,

    @SerializedName("KdfIterations")
    val kdfIterations: Int
)