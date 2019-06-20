package com.mlsdev.mlsdevstore.tests.store.robots.action

import com.mlsdev.mlsdevstore.R
import com.mlsdev.mlsdevstore.common.BaseTestRobot
import com.mlsdev.mlsdevstore.tests.store.constants.StoreConstants

/**
 * Created by bruno.soares on 2019-06-19.
 */
fun actionStore(func: StoreActionRobot.() -> Unit) = StoreActionRobot().apply { func() }
class StoreActionRobot : BaseTestRobot() {
    fun store_clickButtoBrowseCategories() {
        syncTextVisible(StoreConstants.BROWSE_CATEGORIES)
        clickOnView(BUTTON_BROWSE_CATEGORIES)
    }


    companion object {
        const val STORE = R.id.store_flow_fragment
        const val BUTTON_BROWSE_CATEGORIES = R.id.button_browse_categories
    }
}