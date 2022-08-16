package com.parsuomash.affogato.coroutines.android

import kotlinx.coroutines.CoroutineDispatcher

/**
 * ## DispatcherProvider
 * In coroutines, we need special dispatchers for a scope,
 * and in a large project to manage these dispatchers in the main source and test source,
 * we can use the implementation of this interface.
 *
 * @since 1.2.0
 * @see CoroutineDispatcher
 * @see StandardDispatchers
 * @see TestDispatchers
 */
interface DispatchersProvider {
  val main: CoroutineDispatcher
  val io: CoroutineDispatcher
  val default: CoroutineDispatcher
  val unconfined: CoroutineDispatcher
}
