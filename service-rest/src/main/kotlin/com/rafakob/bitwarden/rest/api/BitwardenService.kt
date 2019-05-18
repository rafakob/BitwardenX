package com.rafakob.bitwarden.rest.api

import com.rafakob.bitwarden.rest.retrofit.BitwardenRetrofitApi
import com.rafakob.bitwarden.rest.url.UrlProvider
import retrofit2.Retrofit
import javax.inject.Inject

class BitwardenService @Inject constructor(
    private val urlProvider: UrlProvider,
    private val retrofit: Retrofit
) : BitwardenApi {

    private val api: BitwardenRetrofitApi by lazy { retrofit.create(BitwardenRetrofitApi::class.java) }
}