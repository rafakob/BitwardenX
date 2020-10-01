package com.rafakob.bitwardenx.rest.api

import android.content.Context
import com.rafakob.bitwardenx.rest.body.PasswordHintBody
import com.rafakob.bitwardenx.rest.mapErrorToResult
import com.rafakob.bitwardenx.rest.result.PasswordHintResult
import com.rafakob.bitwardenx.rest.result.RestError
import com.rafakob.bitwardenx.rest.retrofit.VaultRetrofitApi
import com.rafakob.bitwardenx.rest.url.UrlProvider
import io.reactivex.Single
import org.json.JSONObject
import retrofit2.Retrofit
import javax.inject.Inject

class VaultService @Inject constructor(
        private val urlProvider: UrlProvider,
        private val retrofit: Retrofit,
        private val context: Context
) : VaultApi {

    private val api: VaultRetrofitApi by lazy { retrofit.create(VaultRetrofitApi::class.java) }

    override fun passwordHint(email: String): Single<PasswordHintResult> {
        return api.passwordHint(urlProvider.getVaultUrl(), PasswordHintBody(email = email))
                .toSingle<PasswordHintResult> { PasswordHintResult.Success }
                .mapErrorToResult {
                    when (it) {
                        is RestError.ConnectionError -> PasswordHintResult.Failure(context.getString(it.msgRes!!))
                        is RestError.UnknownError -> PasswordHintResult.Failure(context.getString(it.msgRes!!))
                        is RestError.ApiError -> {
                            try {
                                val msg = JSONObject(it.errorBody.toString()).getString("Message")
                                PasswordHintResult.Failure(msg)
                            } catch (e: Exception) {
                                e.printStackTrace()
                                PasswordHintResult.Failure(context.getString(RestError.UnknownError().msgRes!!))
                            }
                        }
                    }
                }
    }
}