package com.mlsdev.mlsdevstore.tests.account.robots.action

import com.mlsdev.mlsdevstore.R
import com.mlsdev.mlsdevstore.common.BaseTestRobot

/**
 * Created by bruno.soares on 2019-06-19.
 */
fun actionAccount(func: AccountActionRobot.() -> Unit) = AccountActionRobot().apply { func() }
class AccountActionRobot : BaseTestRobot() {
    fun account_editPersonalInfo() {
        clickOnView(PERSONAL_INFO_EDIT)
    }

    fun account_editShippingInfo() {
        clickOnView(SHIPPING_INFO)
    }

    companion object {
        const val PERSONAL_INFO_EDIT = R.id.button_edit_personal_info
        const val ACCOUNT = R.id.account_flow_fragment
        const val SHIPPING_INFO = R.id.button_edit_shipping_info
    }
}