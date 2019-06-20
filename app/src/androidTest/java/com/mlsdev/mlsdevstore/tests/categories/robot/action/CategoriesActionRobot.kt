package com.mlsdev.mlsdevstore.tests.categories.robot.action

import com.mlsdev.mlsdevstore.R
import com.mlsdev.mlsdevstore.common.BaseTestRobot

/**
 * Created by bruno.soares on 2019-06-19.
 */
fun actionCategory(func: CategoriesActionRobot.() -> Unit) = CategoriesActionRobot().apply { func() }
class CategoriesActionRobot : BaseTestRobot() {
    fun categories_clickCategory(category: String) = scrollToTextAndClick(category)

    companion object {
        const val BUTTON_BROWSE_CATEGORIES = R.id.button_browse_categories
    }
}