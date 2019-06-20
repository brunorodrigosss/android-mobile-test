package com.mlsdev.mlsdevstore.tests.personalInfo.robots.action

import com.mlsdev.mlsdevstore.R
import com.mlsdev.mlsdevstore.common.BaseTestRobot

/**
 * Created by bruno.soares on 2019-06-19.
 */
fun actionPersonalInfo(func: PersonalInfoActionRobot.() -> Unit) = PersonalInfoActionRobot().apply { func() }
class PersonalInfoActionRobot : BaseTestRobot() {
    fun personalInfo_fillEmail(email: String) {
        enterTextIntoView(EMAIL, email)
    }

    fun personalInfo_fillFirstName(firstName: String) {
        enterTextIntoView(FIRST_NAME, firstName)
    }

    fun personalInfo_fillLastName(lastName: String) {
        enterTextIntoView(LAST_NAME, lastName)
    }

    fun personalInfo_clickSubmitButton() {
        clickOnView(BUTTON_SUBMIT)
    }

    fun personalInfo_fillPersonalInfo(email: String, firstName: String, lastName: String) {
        personalInfo_fillEmail(email)
        personalInfo_fillFirstName(firstName)
        personalInfo_fillLastName(lastName)
    }

    companion object {
        const val EMAIL = R.id.email_edit_text
        const val FIRST_NAME = R.id.first_name_edit_text
        const val LAST_NAME = R.id.last_name_edit_text
        const val BUTTON_SUBMIT = R.id.submit_button
    }
}