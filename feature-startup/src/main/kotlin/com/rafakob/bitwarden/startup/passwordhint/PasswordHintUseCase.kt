package com.rafakob.bitwarden.startup.passwordhint

import com.rafakob.bitwarden.base.UseCaseParameterized
import com.rafakob.bitwarden.rest.api.VaultApi
import com.rafakob.bitwarden.rest.result.PasswordHintResult
import com.rafakob.bitwarden.scope.AppScope
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

@AppScope
class PasswordHintUseCase @Inject constructor(
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