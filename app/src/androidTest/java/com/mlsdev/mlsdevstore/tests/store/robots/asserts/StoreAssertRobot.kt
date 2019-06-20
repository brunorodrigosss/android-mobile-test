package com.mlsdev.mlsdevstore.tests.store.robots.asserts

import com.mlsdev.mlsdevstore.common.BaseTestRobot

/**
 * Created by bruno.soares on 2019-06-19.
 */
fun assertStore(func: StoreAssertRobot.() -> Unit) = StoreAssertRobot().apply { func() }
class StoreAssertRobot : BaseTestRobot() {}