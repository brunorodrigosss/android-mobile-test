package com.mlsdev.mlsdevstore.common

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.*
import com.mlsdev.mlsdevstore.R
import com.mlsdev.mlsdevstore.tests.account.robots.action.AccountActionRobot
import com.mlsdev.mlsdevstore.tests.cart.robots.action.CartActionRobot
import com.mlsdev.mlsdevstore.tests.favorites.robots.action.FavoritesActionRobot
import com.mlsdev.mlsdevstore.tests.store.robots.action.StoreActionRobot

/**
 * Created by bruno.soares on 2019-06-19.
 */
open class BaseTestRobot {
    // Arranges
    fun syncTextVisible(text : String) {
        val mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        mDevice.wait(Until.hasObject(By.text(text)), WAIT)
    }
    // Actions
    fun clickOnView(@IdRes viewId: Int) : ViewInteraction =
        Espresso.onView(withId(viewId)).perform(ViewActions.click())

    fun clickIfHasText(text : String) : ViewInteraction =
            onView(withText(text)).perform(ViewActions.click())

    fun sleep(seconds: Int = 1) {
        Thread.sleep(seconds * SLEEP_TIME)
    }

    fun clickStoreTabbar() {
        clickOnView(StoreActionRobot.STORE)
    }

    fun clickFavoritesTabbar() {
        clickOnView(FavoritesActionRobot.FAVORITE_TAB)
    }

    fun clickCartTabbar() {
        clickOnView(CartActionRobot.CART_ICON)
    }

    fun clickAccountTabbar() {
        clickOnView(AccountActionRobot.ACCOUNT)
    }

    fun scrollToTextAndClick(text: String){
        val appViews = UiScrollable(UiSelector().scrollable(true))
        appViews.scrollTextIntoView(text)
        clickIfHasText(text)
    }

    fun closeErrorMessage(){
        syncTextVisible("Something went wrong. Try again later.")
        clickOnView(android.R.id.button1)
    }

    fun clickProductList(product: String) {
        swipeUp(R.id.app_bar_layout)
        sleep(3)

        var textScroll: UiScrollable? = null
        var text: UiObject? = null
        if (product != null) {
            textScroll = UiScrollable(UiSelector().scrollable(true))
            textScroll.scrollIntoView(UiSelector().text(product))
            text = UiObject(UiSelector().text(product))
            text.click()
        }

    }

    fun swipeUp(@IdRes viewId: Int) {
        Espresso.onView(withId(viewId)).perform(swipeUp())
    }

    fun enterTextIntoView(@IdRes viewId: Int, text: String) {
        clearEditText(viewId)
        onView(withId(viewId)).perform(typeText(text))
        closeKeyboard()
    }

    fun clearEditText(@IdRes viewId: Int) {
        onView(withId(viewId)).perform(clearText())
    }

    fun closeKeyboard() {
        Espresso.closeSoftKeyboard()
    }
    // Asserts
    fun assertViewContainsText(text: String) : ViewInteraction =
        Espresso.onView(withText(text)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    companion object {
        const val WAIT = 10000L
        const val SIZE = 5L
        const val SLEEP_TIME = 1000L
    }

    private fun clearPreferences() {
        try {
            // clearing app data
            val runtime = Runtime.getRuntime()
            runtime.exec("pm clear YOUR_APP_PACKAGE_GOES HERE")

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}