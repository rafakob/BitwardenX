package com.rafakob.bitwarden.startup.login

import com.rafakob.bitwarden.startup.navigator.StartupNavigator
import io.mockk.every
import io.mockk.verify
import io.reactivex.Single
import org.junit.Test

class LoginPresenterTest : BaseTest() {
    val email = forger.aString()
    val password = forger.aString()

    val mockView: LoginContract.View = mock()
    val mockStartupNavigator: StartupNavigator = mock()
    val mockLoginUseCase: LoginUseCase = mock()

    val tested = LoginPresenter(
        mockView,
        mockStartupNavigator,
        mockLoginUseCase
    )

    @Test
    fun `login success`() {
        every { mockLoginUseCase.execute(any()) } returns Single.just(LoginUseCase.Result.Success)
        tested.onLoginClick(" $email ", password)

        verify { mockLoginUseCase.execute(LoginUseCase.Params(email, password)) }
        verify { mockStartupNavigator.showRegister() }

    }

    @Test
    fun `navigate to register`() {
        tested.onRegisterClick()

        verify { mockStartupNavigator.showRegister() }
    }

    @Test
    fun `navigate to password hint`() {
        tested.onPasswordHintClick(" $password ")

        verify { mockStartupNavigator.showPasswordHint(password) }
    }
}