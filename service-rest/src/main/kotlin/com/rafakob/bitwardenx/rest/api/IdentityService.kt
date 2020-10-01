package com.rafakob.bitwardenx.rest.api

import com.rafakob.bitwardenx.rest.retrofit.IdentityRetrofitApi
import com.rafakob.bitwardenx.rest.url.UrlProvider
import retrofit2.Retrofit
import javax.inject.Inject

class IdentityService @Inject constructor(
    private val urlProvider: UrlProvider,
    private val retrofit: Retrofit
) : IdentityApi {

    private val api: IdentityRetrofitApi by lazy { retrofit.create(IdentityRetrofitApi::class.java) }

    override fun login(email: String, password: String) =
        api.login(urlProvider.getIdentityUrl(), username = email, password = password)
            .ignoreElement()
}