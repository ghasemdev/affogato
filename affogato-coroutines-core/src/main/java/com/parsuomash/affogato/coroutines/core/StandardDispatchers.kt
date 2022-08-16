package com.parsuomash.affogato.coroutines.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * ## StandardDispatcher
 * Standard dispatcher implementation of [DispatchersProvider] with [CoroutineDispatcher].
 *
 * @since 1.2.0
 */
class StandardDispatchers : DispatchersProvider {
  /**
   * @see Dispatchers.Main
   * @since 1.2.0
   */
  override val main: CoroutineDispatcher
    get() = Dispatchers.Main

  /**
   * @see Dispatchers.IO
   * @since 1.2.0
   */
  override val io: CoroutineDispatcher
    get() = Dispatchers.IO

  /**
   * @see Dispatchers.Default
   * @since 1.2.0
   */
  override val default: CoroutineDispatcher
    get() = Dispatchers.Default

  /**
   * @see Dispatchers.Unconfined
   * @since 1.2.0
   */
  override val unconfined: CoroutineDispatcher
    get() = Dispatchers.Unconfined
}
