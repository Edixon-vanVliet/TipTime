package com.example.tiptime


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.text.NumberFormat

@RunWith(AndroidJUnit4::class)
class CalculatorTests {
    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_20_percent_tip() {
        val cost = 50.00
        val expectedTip = 10.00

        onView(withId(R.id.cost_text))
            .perform(typeText(cost.toString()))

        onView(withId(R.id.radio_amazing))
            .perform(click())

        onView(withId(R.id.button_calculate))
            .perform(click())

        onView(withId(R.id.total))
            .check(
                matches(
                    withText(
                        containsString(
                            NumberFormat.getCurrencyInstance().format(expectedTip)
                        )
                    )
                )
            )
    }

    @Test
    fun calculate_18_percent_tip() {
        val cost = 50.00
        val expectedTip = 9.00

        onView(withId(R.id.cost_text))
            .perform(typeText(cost.toString()))

        onView(withId(R.id.radio_good))
            .perform(click())

        onView(withId(R.id.button_calculate))
            .perform(click())

        onView(withId(R.id.total))
            .check(
                matches(
                    withText(
                        containsString(
                            NumberFormat.getCurrencyInstance().format(expectedTip)
                        )
                    )
                )
            )
    }

    @Test
    fun calculate_15_percent_tip() {
        val cost = 50.00
        val expectedTip = 7.50

        onView(withId(R.id.cost_text))
            .perform(typeText(cost.toString()))

        onView(withId(R.id.button_calculate))
            .perform(click())

        onView(withId(R.id.total))
            .check(
                matches(
                    withText(
                        containsString(
                            NumberFormat.getCurrencyInstance().format(expectedTip)
                        )
                    )
                )
            )
    }

    @Test
    fun calculate_rounded_15_percent_tip() {
        val cost = 50.00
        val expectedTip = 8.00

        onView(withId(R.id.cost_text))
            .perform(typeText(cost.toString()))

        onView(withId(R.id.switch_round))
            .perform(click())

        onView(withId(R.id.button_calculate))
            .perform(click())

        onView(withId(R.id.total))
            .check(
                matches(
                    withText(
                        containsString(
                            NumberFormat.getCurrencyInstance().format(expectedTip)
                        )
                    )
                )
            )
    }
}