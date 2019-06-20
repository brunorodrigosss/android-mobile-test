package com.mlsdev.mlsdevstore.tests.checkout.robots.action

import com.mlsdev.mlsdevstore.R
import com.mlsdev.mlsdevstore.common.BaseTestRobot

/**
 * Created by bruno.soares on 2019-06-19.
 */
fun actionCheckout(func: CheckoutActionRobot.() -> Unit) = CheckoutActionRobot().apply { func() }
class CheckoutActionRobot : BaseTestRobot() {
    fun checkout_fillCardInformation(cardNumber: String, expirationDate: String, cvv: String, cardHolder: String) {
        enterTextIntoView(TEXT_CARD_NUMBER, cardNumber)
        enterTextIntoView(EXPIRATION_DATE, expirationDate)
        enterTextIntoView(CVV, cvv)
        enterTextIntoView(CARD_HOLDER, cardHolder)
    }
    fun checkout_clickPlaceOrder() = clickOnView(PLACE_ORDER)

    companion object {
        const val PLACE_ORDER = R.id.button_place_order
        const val TEXT_CARD_NUMBER = R.id.text_card_number
        const val EXPIRATION_DATE = R.id.text_expiration_date
        const val CVV = R.id.text_cvv
        const val CARD_HOLDER = R.id.text_card_holder
    }
}