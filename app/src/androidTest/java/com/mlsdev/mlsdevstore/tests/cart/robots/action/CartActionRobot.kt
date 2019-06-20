package com.mlsdev.mlsdevstore.tests.cart.robots.action

import com.mlsdev.mlsdevstore.R
import com.mlsdev.mlsdevstore.common.BaseTestRobot
import com.mlsdev.mlsdevstore.tests.cart.constants.CartConstants

/**
 * Created by bruno.soares on 2019-06-19.
 */
fun actionCart(func: CartActionRobot.() -> Unit) = CartActionRobot().apply { func() }
class CartActionRobot : BaseTestRobot() {
    fun cart_removeProduct() = clickOnView(REMOVE_ICON)

    fun cart_clickCheckout() {
        syncTextVisible(CartConstants.CHECKOUT)
        clickOnView(CHECKOUT)
    }

    companion object {
        const val CART_ICON = R.id.cart_flow_fragment
        const val REMOVE_ICON = R.id.button_remove_from_cart
        const val CHECKOUT = R.id.button_checkout
    }
}