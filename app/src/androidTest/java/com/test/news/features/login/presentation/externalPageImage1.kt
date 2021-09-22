package com.test.news.features.login.presentation


import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.test.news.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class externalPageImage1 {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun externalPageImage1() {
        val appCompatEditText = onView(
            allOf(
                withId(R.id.editTextUserName),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.inputLayoutUserName),
                        0
                    ),
                    0
                )
            )
        )
        appCompatEditText.perform(scrollTo(), click())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.editTextUserName),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.inputLayoutUserName),
                        0
                    ),
                    0
                )
            )
        )
        appCompatEditText2.perform(scrollTo(), replaceText("user1"), closeSoftKeyboard())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.editTextPassword),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.inputLayoutPassword),
                        0
                    ),
                    0
                )
            )
        )
        appCompatEditText3.perform(scrollTo(), replaceText("password"), closeSoftKeyboard())

        val appCompatButton = onView(
            allOf(
                withId(R.id.buttonLogin), withText("Login"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    3
                )
            )
        )
        appCompatButton.perform(scrollTo(), click())

        val recyclerView = onView(
            allOf(
                withId(R.id.recyclerViewImageWidget),
                childAtPosition(
                    withId(R.id.recyclerViewNews),
                    0
                )
            )
        )
        val perform = recyclerView.perform(actionOnItemAtPosition<ViewHolder>(0, click()))

//        val editText = onView(
//            allOf(
//                withId(com.android.chrome.R.id.url_bar),
//                withText("newsbtc.com/wp-content/uploads/2020/01/altcoin-crypto-bitcoin-disbelief-wall-street-shutterstock_360101591-1200x780.jpg"),
//                withParent(
//                    allOf(
//                        withId(com.android.chrome.R.id.location_bar),
//                        withParent(withId(com.android.chrome.R.id.toolbar))
//                    )
//                ),
//                isDisplayed()
//            )
//        )
//        editText.check(matches(withText("newsbtc.com/wp-content/uploads/2020/01/altcoin-crypto-bitcoin-disbelief-wall-street-shutterstock_360101591-1200x780.jpg")))

        val recyclerView2 = onView(
            allOf(
                withId(R.id.recyclerViewImageWidget),
                childAtPosition(
                    withId(R.id.recyclerViewNews),
                    0
                )
            )
        )
        recyclerView2.perform(actionOnItemAtPosition<ViewHolder>(0, click()))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
