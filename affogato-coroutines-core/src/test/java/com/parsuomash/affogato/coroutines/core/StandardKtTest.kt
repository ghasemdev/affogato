@file:Suppress("UNREACHABLE_CODE")

package com.parsuomash.affogato.coroutines.core

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
internal class StandardKtTest {
  @Nested
  @DisplayName("suspended try-catch block")
  inner class TryCatchBlock {

    @Test
    @DisplayName("suspended try catch ignore")
    fun tryCatchIgnore() = runTest {
      var num = 0
      suspendedTryCatchIgnore {
        num = 22
        raiseError()
      }
      assertThat(num).isEqualTo(22)
    }

    @Test
    @DisplayName("suspended try catch boolean")
    fun tryCatchBoolean() = runTest {
      val result = suspendedTryCatchBoolean {
        raiseError()
      }
      assertThat(result).isFalse()

      val result2 = suspendedTryCatchBoolean {
        var num = 0
        num++
        print(num)
      }
      assertThat(result2).isTrue()

      val result3 = suspendedTryCatchBool {
        raiseError()
      }
      assertThat(result3).isFalse()

      val result4 = suspendedTryCatchBool {
        false
      }
      assertThat(result4).isFalse()
    }

    @Test
    @DisplayName("suspended try catch null")
    fun tryCatchNull() = runTest {
      var num = 0
      val result = suspendedTryCatchNull {
        raiseError()
        num++
      }
      assertThat(result).isNull()

      val result2 = suspendedTryCatchNull {
        ++num
      }
      assertThat(result2).isEqualTo(1)
    }

    @Test
    @DisplayName("suspended try catch else")
    fun tryCatchElse() = runTest {
      var num = 0
      val result = suspendedTryCatchElse(elseBlock = { --num }) {
        raiseError()
        ++num
      }
      assertThat(result).isEqualTo(-1)

      val result2 = suspendedTryCatchElse(elseBlock = { --num }) {
        ++num
      }
      assertThat(result2).isEqualTo(0)
    }
  }

  private fun raiseError(): Nothing = throw IllegalArgumentException()
}
