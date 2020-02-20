package com.rafakob.bitwarden.startup.login

import RxRule
import fr.xgouchet.elmyr.junit.JUnitForger
import io.mockk.mockk
import org.junit.Rule

abstract class BaseTest {

    @get:Rule
    val forger = JUnitForger()

    @get:Rule
    val rxRule = RxRule()

    inline fun <reified T : Any> mock() = mockk<T>(relaxed = true)
}