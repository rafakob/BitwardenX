package com.rafakob.bitwarden.startup.login

import com.rafakob.bitwarden.base.UseCaseParameterized
import com.rafakob.bitwarden.rest.api.IdentityApi
import com.rafakob.bitwarden.scope.AppScope
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

@AppScope
class LoginUseCase @Inject constructor(
        private val identityApi: IdentityApi
) : UseCaseParameterized<LoginUseCase.Params, Single<LoginUseCase.Result>> {

    override fun execute(params: Params, subscribeScheduler: Scheduler, observeScheduler: Scheduler) =
            identityApi.login(params.email, params.password)
                    .subscribeOn(subscribeScheduler)
                    .observeOn(observeScheduler)
                    .toSingle<Result> { Result.Success }
                    .onErrorReturn { Result.Failure(it.message.toString()) }

    data class Params(
            val email: String,
            val password: String
    )

    sealed class Result {
        object Success : Result()
        data class Failure(val reason: String) : Result()
    }
}