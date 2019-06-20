package com.mlsdev.mlsdevstore.tests.healthBeauty.robots.action

import com.mlsdev.mlsdevstore.R
import com.mlsdev.mlsdevstore.common.BaseTestRobot

/**
 * Created by bruno.soares on 2019-06-19.
 */
fun actionHealthBeauty(func: HealthBeautyActionRobot.() -> Unit) = HealthBeautyActionRobot().apply { func() }
class HealthBeautyActionRobot : BaseTestRobot() {
    fun store_clickMakeupProduct(product: String) {
        syncTextVisible(product)
        clickIfHasText(product)
    }

    companion object {
        const val BUTTON_BROWSE_CATEGORIES = R.id.button_browse_categories
    }
}