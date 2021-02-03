package com.rafakob.bitwardenx.rest.retrofit

import android.os.Build
import com.rafakob.bitwardenx.rest.response.LoginResponse
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Path

internal interface IdentityRetrofitApi {

    @POST("{endpoint}/connect/token")
    @FormUrlEncoded
    fun login(
        @Path("endpoint", encoded = true) endpoint: String,
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("grant_type") grantType: String = "password",
        @Field("api") api: String = "offline_access",
        @Field("client_id") clientId: String = "mobile",
        @Field("deviceType") deviceType: Int = 0,
        @Field("deviceIdentifier") deviceIdentifier: String = Build.MODEL,
        @Field("deviceName") deviceName: String = "android",
    ): Single<LoginResponse>
}