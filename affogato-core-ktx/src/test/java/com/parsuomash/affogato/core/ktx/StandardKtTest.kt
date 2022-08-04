@file:Suppress("UNREACHABLE_CODE")

package com.parsuomash.affogato.core.ktx

import com.google.common.truth.Truth.assertThat
import com.parsuomash.affogato.core.ktx.collections.dequeOf
import com.parsuomash.affogato.core.ktx.collections.linkedListOf
import com.parsuomash.affogato.core.ktx.collections.queueOf
import com.parsuomash.affogato.core.ktx.collections.stackOf
import java.util.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class StandardKtTest {
  @Nested
  @DisplayName("counter")
  inner class Counter {
    @Test
    @DisplayName("string")
    fun string() {
      assertThat(counter("")).isEqualTo(emptyMap<String, Int>())
      assertThat(counter("abc")).isEqualTo(mapOf('a' to 1, 'b' to 1, 'c' to 1))
    }

    @OptIn(ExperimentalUnsignedTypes::class)
    @Test
    @DisplayName("arrays")
    fun arrays() {
      assertThat(counter(emptyArray<String>()))
        .isEqualTo(emptyMap<String, Int>())
      assertThat(counter(arrayOf(1, 2, 1)))
        .isEqualTo(mapOf(1 to 2, 2 to 1))
      assertThat(counter(arrayOf("a", "d", "d", "d")))
        .isEqualTo(mapOf("a" to 1, "d" to 3))

      assertThat(counter(byteArrayOf(1, 2, 1)))
        .isEqualTo(mutableMapOf(1.toByte() to 2, 2.toByte() to 1))
      assertThat(counter(charArrayOf('a', 'b', 'a')))
        .isEqualTo(mapOf('a' to 2, 'b' to 1))
      assertThat(counter(shortArrayOf(1, 2, 1)))
        .isEqualTo(mapOf(1.toShort() to 2, 2.toShort() to 1))
      assertThat(counter(intArrayOf(1, 2, 1)))
        .isEqualTo(mapOf(1 to 2, 2 to 1))
      assertThat(counter(uintArrayOf(1u, 2u, 1u)))
        .isEqualTo(mapOf(1u to 2, 2u to 1))
      assertThat(counter(longArrayOf(1L, 2L, 1L)))
        .isEqualTo(mapOf(1L to 2, 2L to 1))
      assertThat(counter(floatArrayOf(1F, 2F, 1F)))
        .isEqualTo(mapOf(1F to 2, 2F to 1))
      assertThat(counter(doubleArrayOf(1.0, 2.0, 1.0)))
        .isEqualTo(mapOf(1.0 to 2, 2.0 to 1))
      assertThat(counter(booleanArrayOf(false, true, false)))
        .isEqualTo(mapOf(false to 2, true to 1))
    }

    @Test
    @DisplayName("stack")
    fun stack() {
      assertThat(counter(stackOf("a", "a", "a", "b"))).isEqualTo(mapOf("a" to 3, "b" to 1))
      assertThat(counter(stackOf(1, 2, 3, 2, 1, 3))).isEqualTo(mapOf(1 to 2, 2 to 2, 3 to 2))
    }

    @Test
    @DisplayName("queues")
    fun queues() {
      assertThat(counter(queueOf("a", "a", "a", "b"))).isEqualTo(mapOf("a" to 3, "b" to 1))
      assertThat(counter(dequeOf("a", "d", "d", "d"))).isEqualTo(mapOf("a" to 1, "d" to 3))
    }

    @Test
    @DisplayName("lists")
    fun lists() {
      assertThat(counter(mutableListOf(1, 2, 1))).isEqualTo(mapOf(1 to 2, 2 to 1))
      assertThat(counter(linkedListOf("a", "a", "a", "b"))).isEqualTo(mapOf("a" to 3, "b" to 1))
      assertThat(counter(listOf("a", "a", "a", "b", 5, 2.3, null)))
        .isEqualTo(mapOf("a" to 3, "b" to 1, 5 to 1, 2.3 to 1, null to 1))
    }
  }

  @Test
  @DisplayName("or default")
  fun orDefault() {
    val date: Date? = null
    val now = Date()
    assertThat(date.orDefault(now)).isEqualTo(now)

    val str: String? = null
    assertThat(str.orDefault("")).isEmpty()
  }

  @Nested
  @DisplayName("check nullability")
  inner class CheckNullability {
    @Test
    @DisplayName("value is null")
    fun isNull() {
      val text: String? = null
      assertThat(text.isNull()).isTrue()

      val text2 = "hi"
      assertThat(text2.isNull()).isFalse()
    }

    @Test
    @DisplayName("value is not null")
    fun isNotNull() {
      val text: String? = null
      assertThat(text.isNotNull()).isFalse()

      val text2 = "hi"
      assertThat(text2.isNotNull()).isTrue()
    }
  }

  @Nested
  @DisplayName("nullability conditions")
  inner class NullabilityConditions {
    @Test
    @DisplayName("if value null")
    fun ifNull() {
      val value: String? = null
      val result = value.ifNull {
        print("$it : is null")
      } as Unit
      assertThat(result).isEqualTo(Unit)

      val value2 = "hello"
      val result2 = value2.ifNull {
        print("this is never print")
      } as String
      assertThat(result2).isEqualTo(value2)
    }

    @Test
    @DisplayName("ifNull with returns value")
    fun ifNullReturn() {
      val value: String? = null
      val result = value.ifNull {
        print("$value : is null")
        "i am not null"
      } as String
      assertThat(result).isEqualTo("i am not null")

      val value2 = "hello"
      val result2 = value2.ifNull {
        print("this is never print")
        "i am not null"
      } as String
      assertThat(result2).isEqualTo(value2)
    }

    @Test
    @DisplayName("if value not null")
    fun ifNotNull() {
      val value: String? = null
      val result = value.ifNotNull {
        print("this is never print")
      }
      assertThat(result).isNull()

      val value2 = "hello"
      val result2 = value2.ifNotNull {
        print("value is $value2")
      } as Unit
      assertThat(result2).isEqualTo(Unit)
    }

    @Test
    @DisplayName("ifNotNull with returns value")
    fun ifNotNullReturn() {
      val value: String? = null
      val result = value.ifNotNull {
        print("this is never print")
        "i am not null"
      }
      assertThat(result).isNull()

      val value2 = "hello"
      val result2 = value2.ifNotNull {
        print("value is $value2")
        "i am not null"
      } as String
      assertThat(result2).isEqualTo("i am not null")
    }
  }

  @Nested
  @DisplayName("try-catch block")
  inner class TryCatchBlock {
    @Test
    @DisplayName("try catch ignore")
    fun tryCatchIgnore() {
      var num = 0
      tryCatchIgnore {
        num = 22
        raiseError()
      }
      assertThat(num).isEqualTo(22)
    }

    @Test
    @DisplayName("try catch boolean")
    fun tryCatchBoolean() {
      val result = tryCatchBoolean {
        raiseError()
      }
      assertThat(result).isFalse()

      val result2 = tryCatchBoolean {
        var num = 0
        num++
        print(num)
      }
      assertThat(result2).isTrue()
    }

    @Test
    @DisplayName("try catch null")
    fun tryCatchNull() {
      var num = 0
      val result = tryCatchNull {
        raiseError()
        num++
      }
      assertThat(result).isNull()

      val result2 = tryCatchNull {
        ++num
      }
      assertThat(result2).isEqualTo(1)
    }

    @Test
    @DisplayName("try catch else")
    fun tryCatchElse() {
      var num = 0
      val result = tryCatchElse(elseBlock = { --num }) {
        raiseError()
        ++num
      }
      assertThat(result).isEqualTo(-1)

      val result2 = tryCatchElse(elseBlock = { --num }) {
        ++num
      }
      assertThat(result2).isEqualTo(0)
    }
  }

  private fun raiseError(): Nothing = throw IllegalArgumentException()
}
