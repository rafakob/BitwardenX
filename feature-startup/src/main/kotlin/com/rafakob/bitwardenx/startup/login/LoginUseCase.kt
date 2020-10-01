package com.rafakob.bitwardenx.startup.login

import com.rafakob.bitwardenx.base.UseCaseParameterized
import com.rafakob.bitwardenx.rest.api.IdentityApi
import com.rafakob.bitwardenx.rest.result.LoginResult
import com.rafakob.bitwardenx.scope.AppScope
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

@AppScope
class LoginUseCase @Inject constructor(
        private val identityApi: IdentityApi
) : UseCaseParameterized<LoginUseCase.Params, Single<LoginResult>> {

    override fun execute(params: Params, subscribeScheduler: Scheduler, observeScheduler: Scheduler) =
            identityApi.login(params.email, params.password)
                    .subscribeOn(subscribeScheduler)
                    .observeOn(observeScheduler)

    data class Params(
            val email: String,
            val password: String
    )
}