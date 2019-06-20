package com.mlsdev.mlsdevstore.tests.consumerEletronics.robots

import com.mlsdev.mlsdevstore.common.BaseTestRobot

/**
 * Created by bruno.soares on 2019-06-19.
 */
fun actionConsumerEletronics(func: ConsumerEletronicsActionRobot.() -> Unit) = ConsumerEletronicsActionRobot().apply { func() }
class ConsumerEletronicsActionRobot : BaseTestRobot() {
}