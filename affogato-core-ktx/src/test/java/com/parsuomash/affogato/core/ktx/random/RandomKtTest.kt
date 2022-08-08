@file:Suppress("ImportOrdering")

package com.parsuomash.affogato.core.ktx.random

import com.parsuomash.affogato.core.ktx.collections.listOf
import kotlin.random.Random
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`in`
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.everyItem
import org.hamcrest.Matchers.nullValue
import org.junit.jupiter.api.Test

internal class RandomKtTest {
  @Test
  fun nextInt() {
    val random = Random.nextInt(1..10 step 2)
    assertThat(random, `in`(listOf(1..10)))
  }

  @Test
  fun nextUInt() {
    val random = Random.nextUInt(1u..10u step 2)
    assertThat(random, `in`(listOf(1u..10u)))
  }

  @Test
  fun nextLong() {
    val random = Random.nextLong(1..10L step 2)
    assertThat(random, `in`(listOf(1..10L)))
  }

  @Test
  fun nextULong() {
    val random = Random.nextULong(1uL..10uL step 2)
    assertThat(random, `in`(listOf(1uL..10uL)))
  }

  @Test
  fun `choice vars`() {
    val array = arrayOf(1, 2, 3, 4, 5)
    val number = Random.choice(1, 2, 3, 4, 5)
    assertThat(number, `in`(array))
  }

  @Test
  fun `choice array`() {
    val array = arrayOf(1, 2, 3, 4, 5)
    val number = Random.choice(array)
    assertThat(number, `in`(array))
  }

  @Test
  fun `choice list`() {
    val list = listOf(1, 2, 3, 4, 5)
    val number = Random.choice(list)
    assertThat(number, `in`(list))
  }

  @Test
  fun `choice set`() {
    val set = setOf(1, 2, 3, 4, 5)
    val number = Random.choice(set)
    assertThat(number, `in`(set))
  }

  @Test
  fun `choice map`() {
    val map = mapOf(1 to 1, 2 to 2, 3 to 3, 4 to 4, 5 to 5)
    val number = Random.choice(map)
    assertThat(number.first, `in`(map.keys))
    assertThat(map.random().first, `in`(map.keys))
  }

  @Test
  fun `choice or null array`() {
    assertThat(Random.choiceOrNull(arrayOf()), `is`(nullValue()))
  }

  @Test
  fun `choice or null list`() {
    assertThat(Random.choiceOrNull(listOf()), `is`(nullValue()))
  }

  @Test
  fun `choice or null set`() {
    assertThat(Random.choiceOrNull(setOf()), `is`(nullValue()))
  }

  @Test
  fun `choice or null map`() {
    assertThat(Random.choiceOrNull(mapOf<String, String>()), `is`(nullValue()))
    assertThat(mapOf<String, String>().randomOrNull(), `is`(nullValue()))
  }

  @Test
  fun `choices array`() {
    val randomList =
      Random.choices(arrayOf(1, 2, 3, 4, 5), weights = listOf(1, 1, 1, 1, 9), length = 20)
    println("1 -> ${randomList.count { it == 1 }}")
    println("2 -> ${randomList.count { it == 2 }}")
    println("3 -> ${randomList.count { it == 3 }}")
    println("4 -> ${randomList.count { it == 4 }}")
    println("5 -> ${randomList.count { it == 5 }}")

    assertThat(randomList, everyItem(`is`(`in`((listOf(1, 2, 3, 4, 5))))))
  }

  @Test
  fun `choices list`() {
    val randomList =
      Random.choices(listOf(1, 2, 3, 4, 5), weights = listOf(1, 1, 1, 1, 1), length = 10)
    println("1 -> ${randomList.count { it == 1 }}")
    println("2 -> ${randomList.count { it == 2 }}")
    println("3 -> ${randomList.count { it == 3 }}")
    println("4 -> ${randomList.count { it == 4 }}")
    println("5 -> ${randomList.count { it == 5 }}")

    assertThat(randomList, everyItem(`is`(`in`((listOf(1, 2, 3, 4, 5))))))
  }

  @Test
  fun `choices elements`() {
    val randomList =
      Random.choices(1, 2, 3, 4, 5, weights = listOf(9, 3, 4, 6, 5), length = 5)
    println("1 -> ${randomList.count { it == 1 }}")
    println("2 -> ${randomList.count { it == 2 }}")
    println("3 -> ${randomList.count { it == 3 }}")
    println("4 -> ${randomList.count { it == 4 }}")
    println("5 -> ${randomList.count { it == 5 }}")

    assertThat(randomList, everyItem(`is`(`in`((listOf(1, 2, 3, 4, 5))))))
  }

  @Test
  fun `choices null`() {
    val randomList =
      Random.choicesOrNull(arrayOf<Int>(), weights = listOf(9, 3, 4, 6, 5), length = 5)
    val randomList2 =
      Random.choicesOrNull(listOf<Int>(), weights = listOf(9, 3, 4, 6, 5), length = 5)
    val randomList3 =
      Random.choicesOrNull(listOf(1, 2), weights = listOf(9, 3, 4), length = 5)
    assertThat(randomList, `is`(nullValue()))
    assertThat(randomList2, `is`(nullValue()))
    assertThat(randomList3, `is`(nullValue()))
  }
}
