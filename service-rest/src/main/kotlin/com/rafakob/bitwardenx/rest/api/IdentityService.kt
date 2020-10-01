package com.rafakob.bitwardenx.rest.api

import android.content.Context
import com.rafakob.bitwardenx.rest.onErrorMapResult
import com.rafakob.bitwardenx.rest.result.LoginResult
import com.rafakob.bitwardenx.rest.result.RestError
import com.rafakob.bitwardenx.rest.retrofit.IdentityRetrofitApi
import com.rafakob.bitwardenx.rest.url.UrlProvider
import io.reactivex.Single
import org.json.JSONObject
import retrofit2.Retrofit
import javax.inject.Inject

class IdentityService @Inject constructor(
        private val urlProvider: UrlProvider,
        private val retrofit: Retrofit,
        private val context: Context,
) : IdentityApi {

    private val api: IdentityRetrofitApi by lazy { retrofit.create(IdentityRetrofitApi::class.java) }

    override fun login(email: String, password: String): Single<LoginResult> =
            api.login(urlProvider.getIdentityUrl(), username = email, password = password)
                    .map<LoginResult> { LoginResult.Success }
                    .onErrorMapResult {
                        when (it) {
                            is RestError.ConnectionError -> LoginResult.Failure(context.getString(it.msgRes!!))
                            is RestError.UnknownError -> LoginResult.Failure(context.getString(it.msgRes!!))
                            is RestError.ApiError -> {
                                try {
                                    val msg = JSONObject(it.errorBody.toString())
                                            .getJSONObject("ErrorModel")
                                            .getString("Message")

                                    LoginResult.Failure(msg)
                                } catch (e: Exception) {
                                    e.printStackTrace()
                                    LoginResult.Failure(context.getString(RestError.UnknownError().msgRes!!))
                                }
                            }
                        }
                    }

}