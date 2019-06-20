package com.mlsdev.mlsdevstore.tests.itemDetails.robots.action

import androidx.test.espresso.ViewInteraction
import com.mlsdev.mlsdevstore.R
import com.mlsdev.mlsdevstore.common.BaseTestRobot
import com.mlsdev.mlsdevstore.tests.itemDetails.constants.ItemDetailsConstant

/**
 * Created by bruno.soares on 2019-06-19.
 */
fun actionItemDetails(func: ItemDetailsActionRobot.() -> Unit) = ItemDetailsActionRobot().apply { func() }
class ItemDetailsActionRobot : BaseTestRobot() {
    fun itemDetails_clickFavoriteIcon() : ViewInteraction = clickOnView(FAVORITE_ICON)
    fun itemDetails_clickAddToCart() : ViewInteraction = clickIfHasText(ItemDetailsConstant.ADD_TO_CART)

    companion object {
        const val FAVORITE_ICON = R.id.add_to_favorites
    }
}