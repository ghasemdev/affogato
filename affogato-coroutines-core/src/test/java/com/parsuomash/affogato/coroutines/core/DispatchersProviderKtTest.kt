package com.parsuomash.affogato.coroutines.core

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class DispatchersProviderKtTest {
  @Test
  @DisplayName("Standard Implementation")
  fun standardImplementation() {
    val dispatcherProvider = StandardDispatchers()
    assertThat(dispatcherProvider).isInstanceOf(DispatchersProvider::class.java)
    assertThat(dispatcherProvider.io).isInstanceOf(CoroutineDispatcher::class.java)
    assertThat(dispatcherProvider.main).isInstanceOf(CoroutineDispatcher::class.java)
    assertThat(dispatcherProvider.default).isInstanceOf(CoroutineDispatcher::class.java)
    assertThat(dispatcherProvider.unconfined).isInstanceOf(CoroutineDispatcher::class.java)
  }

  @OptIn(ExperimentalCoroutinesApi::class)
  @Test
  @DisplayName("Standard Implementation")
  fun testImplementation() {
    val testProvider = TestDispatchers()
    assertThat(testProvider).isInstanceOf(DispatchersProvider::class.java)
    assertThat(testProvider.io).isInstanceOf(TestDispatcher::class.java)
    assertThat(testProvider.main).isInstanceOf(TestDispatcher::class.java)
    assertThat(testProvider.default).isInstanceOf(TestDispatcher::class.java)
    assertThat(testProvider.unconfined).isInstanceOf(TestDispatcher::class.java)
  }
}
