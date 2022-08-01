@file:Suppress("UNREACHABLE_CODE")

package com.parsuomash.affogato.core.ktx

import com.google.common.truth.Truth.assertThat
import java.util.*
import org.junit.Test

class StandardKtTest {
  @Test
  fun `value is null`() {
    val text: String? = null
    assertThat(text.isNull()).isTrue()

    val text2 = "hi"
    assertThat(text2.isNull()).isFalse()
  }

  @Test
  fun `value is not null`() {
    val text: String? = null
    assertThat(text.isNotNull()).isFalse()

    val text2 = "hi"
    assertThat(text2.isNotNull()).isTrue()
  }

  @Test
  fun `if value null`() {
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
  fun `ifNull with returns value`() {
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
  fun `if value not null`() {
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
  fun `ifNotNull with returns value`() {
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

  @Test
  fun `or default`() {
    val date: Date? = null
    val now = Date()
    assertThat(date.orDefault(now)).isEqualTo(now)

    val str: String? = null
    assertThat(str.orDefault("")).isEmpty()
  }

  @Test
  fun `try catch ignore`() {
    var num = 0
    tryCatchIgnore {
      num = 22
      raiseError()
    }
    assertThat(num).isEqualTo(22)
  }

  @Test
  fun `try catch boolean`() {
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
  fun `try catch null`() {
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
  fun `try catch else`() {
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

  private fun raiseError(): Nothing = throw Exception()
}
