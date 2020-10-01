package com.rafakob.bitwardenx

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.rafakob.bitwardenx.main.MainActivity
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, false)

    @Test
    fun helloWord() {
        onView(withId(R.id.helloWorld)).check(matches(withText("Hello World!")))
    }
}