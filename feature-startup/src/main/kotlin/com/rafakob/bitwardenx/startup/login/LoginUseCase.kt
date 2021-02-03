package com.rafakob.bitwardenx.startup.login

import com.rafakob.bitwardenx.base.UseCaseParameterized
import com.rafakob.bitwardenx.crypto.CryptoApi
import com.rafakob.bitwardenx.crypto.kdf.KdfType
import com.rafakob.bitwardenx.rest.api.BitwardenApi
import com.rafakob.bitwardenx.rest.api.IdentityApi
import com.rafakob.bitwardenx.rest.result.LoginResult
import com.rafakob.bitwardenx.scope.AppScope
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

@AppScope
class LoginUseCase @Inject constructor(
        private val bitwardenApi: BitwardenApi,
        private val identityApi: IdentityApi,
        private val cryptoApi: CryptoApi,
) : UseCaseParameterized<LoginUseCase.Params, Single<LoginResult>> {

    override fun execute(params: Params, subscribeScheduler: Scheduler, observeScheduler: Scheduler) =
            bitwardenApi.preLogin(params.email)
                    .andThen(identityApi.login(params.email, generatePassword(params.password, params.email, 100000)))
                    .subscribeOn(subscribeScheduler)
                    .observeOn(observeScheduler)

    data class Params(
            val email: String,
            val password: String
    )

    private fun generatePassword(password: String, email: String, kdfIterations: Int): String {
        val key = cryptoApi.makeKeyFromPassword(password, email, KdfType.PBKDF2_SHA256, kdfIterations)
        return cryptoApi.hashPasswordBase64(key, password)
    }
}