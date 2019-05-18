package com.rafakob.bitwarden.rest.api

import com.rafakob.bitwarden.rest.retrofit.IdentityRetrofitApi
import com.rafakob.bitwarden.rest.url.UrlProvider
import retrofit2.Retrofit
import javax.inject.Inject

class IdentityService @Inject constructor(
    private val urlProvider: UrlProvider,
    private val retrofit: Retrofit
) : IdentityApi {

    private val api: IdentityRetrofitApi by lazy { retrofit.create(IdentityRetrofitApi::class.java) }
}