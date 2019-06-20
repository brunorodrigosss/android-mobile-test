package com.mlsdev.mlsdevstore.tests.baby.robots.action

import com.mlsdev.mlsdevstore.R
import com.mlsdev.mlsdevstore.common.BaseTestRobot

/**
 * Created by bruno.soares on 2019-06-19.
 */
fun actionBaby(func: BabyActionRobot.() -> Unit) = BabyActionRobot().apply { func() }
class BabyActionRobot : BaseTestRobot() {
    fun cart_removeProduct() = clickOnView(REMOVE_ICON)

    companion object {
        const val CART_ICON = R.id.cart_flow_fragment
        const val REMOVE_ICON = R.id.button_remove_from_cart
    }
}