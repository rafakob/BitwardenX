package com.rafakob.bitwardenx.startup.passwordhint

import com.rafakob.bitwardenx.base.UseCaseParameterized
import com.rafakob.bitwardenx.rest.api.VaultApi
import com.rafakob.bitwardenx.rest.result.PasswordHintResult
import com.rafakob.bitwardenx.scope.AppScope
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

@AppScope
internal class PasswordHintUseCase @Inject constructor(
        private val vaultApi: VaultApi
) : UseCaseParameterized<PasswordHintUseCase.Params, Single<PasswordHintResult>> {

    override fun execute(params: Params, subscribeScheduler: Scheduler, observeScheduler: Scheduler) =
            vaultApi.passwordHint(params.email)
                    .subscribeOn(subscribeScheduler)
                    .observeOn(observeScheduler)

    data class Params(
            val email: String
    )
}