package com.mlsdev.mlsdevstore.tests.cart.robots.asserts

import com.mlsdev.mlsdevstore.common.BaseTestRobot

/**
 * Created by bruno.soares on 2019-06-19.
 */
fun assertCart(func: CartAssertRobot.() -> Unit) = CartAssertRobot().apply { func() }
class CartAssertRobot : BaseTestRobot() {
    fun cart_assertCart(product: String) {
        syncTextVisible(product)
        assertViewContainsText(product)
    }
}