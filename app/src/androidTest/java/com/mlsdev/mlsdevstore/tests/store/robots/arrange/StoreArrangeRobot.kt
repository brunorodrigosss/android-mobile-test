package com.mlsdev.mlsdevstore.tests.store.robots.arrange

import com.mlsdev.mlsdevstore.common.BaseTestRobot
import com.mlsdev.mlsdevstore.tests.store.constants.StoreConstants

/**
 * Created by bruno.soares on 2019-06-19.
 */
fun arrangeStore(func: StoreArrangeRobot.() -> Unit) = StoreArrangeRobot().apply { func() }
class StoreArrangeRobot : BaseTestRobot() {
    fun assyncWait() = syncTextVisible(StoreConstants.TITLE)
}