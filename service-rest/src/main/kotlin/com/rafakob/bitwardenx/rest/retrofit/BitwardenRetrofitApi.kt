package com.rafakob.bitwardenx.rest.retrofit

import com.rafakob.bitwardenx.rest.body.PreLoginBody
import com.rafakob.bitwardenx.rest.response.PreLoginResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

internal interface BitwardenRetrofitApi {

    @POST("{endpoint}/accounts/prelogin")
    fun preLogin(
        @Path("endpoint", encoded = true) endpoint: String,
        @Body body: PreLoginBody
    ): Single<PreLoginResponse>
}