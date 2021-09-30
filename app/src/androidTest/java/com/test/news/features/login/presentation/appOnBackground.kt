package com.test.news.features.login.presentation


import android.app.Instrumentation
import android.content.Intent
import android.os.Build.ID
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.TypedArrayUtils.getText
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.toPackage
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import com.google.android.apps.common.testing.accessibility.framework.replacements.Uri
import com.test.news.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.*
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.xml.sax.Locator
import java.net.HttpCookie.parse
import java.util.logging.Level.parse
import java.util.regex.Pattern.matches

// This test has not been completed


@LargeTest
@RunWith(AndroidJUnit4::class)
class appOnBackground {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityScenarioRule(LoginActivity::class.java)

    @get:Rule
    val intentsTestRule = IntentsTestRule(LoginActivity::class.java)

    fun setUp() {
        onWebView().forceJavascriptEnabled()
    }

    @Test
    fun appOnBackground() {
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

        val appCompatEditText3 = onView(
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
        appCompatEditText3.perform(scrollTo(), replaceText("user1"), closeSoftKeyboard())

        val appCompatEditText4 = onView(
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
        appCompatEditText4.perform(scrollTo(), replaceText("password"), closeSoftKeyboard())

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
                    2
                )
            )
        )
        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(0, click()))

    }

    public void testWebPage()throws Exception
    {
        onWebView().withElement(findElement(Locator.ID, "https://static.foxnews.com/foxnews.com/content/uploads/2020/01/Tom-Brady-split.jpg"))
        .check(webMatches(getText(), containsString("https://static.foxnews.com/foxnews.com/content/uploads/2020/01/Tom-Brady-split.jpg")));
    }

    private fun onWebView(): Any {

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
    private fun clickOnImage_opensNewWindow() {
            .withElement(findElement(Locator.ID, "text_input"))
            .check(webMatches(getText(), containsString("https://static.foxnews.com/foxnews.com/content/uploads/2020/01/Tom-Brady-split.jpg")))
    }
 }




