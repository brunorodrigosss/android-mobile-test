package com.mlsdev.mlsdevstore.tests.favorites.robots.action

import com.mlsdev.mlsdevstore.R
import com.mlsdev.mlsdevstore.common.BaseTestRobot

/**
 * Created by bruno.soares on 2019-06-19.
 */
fun actionFavorites(func: FavoritesActionRobot.() -> Unit) = FavoritesActionRobot().apply { func() }
class FavoritesActionRobot : BaseTestRobot() {
    fun favorites_clickFavoritesTabbar() {
        sleep(5)
        clickFavoritesTabbar()

    }

    companion object {
        const val FAVORITE_TAB = R.id.favorites_flow_fragment
    }
}