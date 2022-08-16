package com.parsuomash.affogato.coroutines.android

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher

/**
 * ## TestDispatcher
 * Test dispatcher implementation of [DispatchersProvider] with [StandardTestDispatcher].
 *
 * @since 1.2.0
 */
class TestDispatchers : DispatchersProvider {
  /**
   * @see StandardTestDispatcher
   * @since 1.2.0
   */
  @OptIn(ExperimentalCoroutinesApi::class)
  override val main: CoroutineDispatcher
    get() = StandardTestDispatcher()

  /**
   * @see StandardTestDispatcher
   * @since 1.2.0
   */
  @OptIn(ExperimentalCoroutinesApi::class)
  override val io: CoroutineDispatcher
    get() = StandardTestDispatcher()

  /**
   * @see StandardTestDispatcher
   * @since 1.2.0
   */
  @OptIn(ExperimentalCoroutinesApi::class)
  override val default: CoroutineDispatcher
    get() = StandardTestDispatcher()

  /**
   * @see StandardTestDispatcher
   * @since 1.2.0
   */
  @OptIn(ExperimentalCoroutinesApi::class)
  override val unconfined: CoroutineDispatcher
    get() = StandardTestDispatcher()
}
