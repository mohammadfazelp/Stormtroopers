package com.faz.presentation.test.factory

import java.util.concurrent.ThreadLocalRandom

/**
 * Factory class for data instances
 */
class DataFactory {

    companion object Factory {

        fun randomUuid(): String {
            return java.util.UUID.randomUUID().toString()
        }

        fun randomInt(): Int {
            return ThreadLocalRandom.current().nextInt(0, 1000 + 1)
        }

        fun randomFloat(): Float {
            return randomInt().toFloat()
        }

        fun randomLong(): Long {
            return randomInt().toLong()
        }

    }

}