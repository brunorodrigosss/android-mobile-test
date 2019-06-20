package com.mlsdev.mlsdevstore.tests.categories.robot.assert

import com.mlsdev.mlsdevstore.common.BaseTestRobot
import com.mlsdev.mlsdevstore.tests.categories.constants.CategoriesConstants

/**
 * Created by bruno.soares on 2019-06-19.
 */
fun assertCategory(func: CategoriesAssertRobot.() -> Unit) = CategoriesAssertRobot().apply { func() }
class CategoriesAssertRobot : BaseTestRobot() {
    fun categories_assertCategoriesList() {
        assertViewContainsText(CategoriesConstants.COLLECTIBLES)
        assertViewContainsText(CategoriesConstants.EVERYTHING_ELSE)
        assertViewContainsText(CategoriesConstants.TOYS_HOBBIES)
        assertViewContainsText(CategoriesConstants.DOLLS_BEARS)
        assertViewContainsText(CategoriesConstants.STAMPS)
        assertViewContainsText(CategoriesConstants.JEWELRY_WATCHES)
    }
}