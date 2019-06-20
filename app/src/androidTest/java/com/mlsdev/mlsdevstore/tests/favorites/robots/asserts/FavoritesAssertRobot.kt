package com.mlsdev.mlsdevstore.tests.favorites.robots.asserts

import com.mlsdev.mlsdevstore.common.BaseTestRobot

/**
 * Created by bruno.soares on 2019-06-19.
 */
fun assertFavorites(func: FavoritesAssertRobot.() -> Unit) = FavoritesAssertRobot().apply { func() }
class FavoritesAssertRobot : BaseTestRobot() {
    fun favorites_assertFavorites(prodcut: String) = assertViewContainsText(prodcut)
}