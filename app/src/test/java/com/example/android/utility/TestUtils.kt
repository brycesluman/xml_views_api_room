package com.example.android.utility

import org.mockito.ArgumentMatchers.anyObject
import org.mockito.Mockito.mock

/**
 * Helper class to provide static access to handy methods
 */
object TestUtils {

        /**
         * More elegant way of mocking classes for kotlin to avoid ::class.java trailing
         */
        inline fun <reified T> mokk(): T {
            return mock(T::class.java)
        }

        /**
         * Replacement for default anyObject() to return NonNull
         */
        fun <T> anyMokk(): T {
            @Suppress("RemoveExplicitTypeArguments")
            return anyObject<T>()
        }
}