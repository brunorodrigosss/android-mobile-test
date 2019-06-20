package com.mlsdev.mlsdevstore.tests.shippingInfo.robots.action

import com.mlsdev.mlsdevstore.R
import com.mlsdev.mlsdevstore.common.BaseTestRobot

/**
 * Created by bruno.soares on 2019-06-19.
 */
fun actionShippingInfo(func: ShippingInfoActionRobot.() -> Unit) = ShippingInfoActionRobot().apply { func() }
class ShippingInfoActionRobot : BaseTestRobot() {
    fun personalInfo_fillPhoneNumber(phoneNumber: String) {
        enterTextIntoView(PHONE_NUMBER, phoneNumber)
    }

    fun personalInfo_fillAddress(address: String) {
        enterTextIntoView(ADDRESS, address)
    }

    fun personalInfo_fillCity(city: String) {
        enterTextIntoView(CITY, city)
    }

    fun personalInfo_fillState(state: String) {
        enterTextIntoView(STATE, state)
    }

    fun personalInfo_fillPostalCode(postalCode: String) {
        enterTextIntoView(POSTAL_CODE, postalCode)
    }

    fun personalInfo_clickSubmitButton() {
        clickOnView(SUBMIT)
    }

    fun personalInfo_fillShippingInfo(phoneNumber: String, address: String, city: String,
                                      state: String, postalCode: String) {
        personalInfo_fillPhoneNumber(phoneNumber)
        personalInfo_fillAddress(address)
        personalInfo_fillCity(city)
        personalInfo_fillState(state)
        personalInfo_fillPostalCode(postalCode)
        personalInfo_clickSubmitButton()
    }

    companion object {
        const val PHONE_NUMBER = R.id.edit_text_phone_number
        const val ADDRESS = R.id.edit_text_address
        const val CITY = R.id.edit_text_city
        const val STATE = R.id.edit_text_state
        const val POSTAL_CODE = R.id.edit_text_postal_code
        const val SUBMIT = R.id.submit_button
    }
}