package com.rafakob.bitwarden.rest.response

import com.google.gson.annotations.SerializedName

internal data class LoginResponse(

    @SerializedName("access_token")
    val accessToken: String,

    @SerializedName("expires_in")
    val expiresIn: Int,

    @SerializedName("token_type")
    val tokenType: String,

    @SerializedName("refresh_token")
    val refreshToken: String,

    @SerializedName("PrivateKey")
    val privateKey: String,

    @SerializedName("Key")
    val key: String
)