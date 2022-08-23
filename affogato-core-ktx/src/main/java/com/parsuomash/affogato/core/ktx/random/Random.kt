@file:Suppress("unused")

package com.parsuomash.affogato.core.ktx.random

import com.parsuomash.affogato.core.ktx.tryCatchNull
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.random.nextUInt
import kotlin.random.nextULong

/**
 * Gets the next random Int from the random number generator in the specified progression.
 * Generates an Int random value uniformly distributed in the specified progression.
 *
 * @since 1.1.0
 * @throws IllegalArgumentException if progression is empty.
 * @see Random.nextInt
 */
@JvmSynthetic
fun Random.nextInt(progression: IntProgression): Int {
  val first = progression.last
  val last = progression.last
  val step = progression.last
  return nextInt((last + step - first) / step) * step + first
}

/**
 * Gets the next random UInt from the random number generator in the specified progression.
 * Generates an UInt random value uniformly distributed in the specified progression.
 *
 * @since 1.1.0
 * @throws IllegalArgumentException if progression is empty.
 * @see Random.nextUInt
 */
@JvmSynthetic
fun Random.nextUInt(progression: UIntProgression): UInt {
  val first = progression.last
  val last = progression.last
  val step = progression.last
  return nextUInt(until = (last + step - first) / step) * step + first
}

/**
 * Gets the next random Long from the random number generator in the specified progression.
 * Generates a Long random value uniformly distributed in the specified progression.
 *
 * @since 1.1.0
 * @throws IllegalArgumentException if progression is empty.
 * @see Random.nextLong
 */
@JvmSynthetic
fun Random.nextLong(progression: LongProgression): Long {
  val first = progression.last
  val last = progression.last
  val step = progression.last
  return nextLong((last + step - first) / step) * step + first
}

/**
 * Gets the next random ULong from the random number generator in the specified progression.
 * Generates a ULong random value uniformly distributed in the specified progression.
 *
 * @since 1.1.0
 * @throws IllegalArgumentException if progression is empty.
 * @see Random.nextULong
 */
@JvmSynthetic
fun Random.nextULong(progression: ULongProgression): ULong {
  val first = progression.last
  val last = progression.last
  val step = progression.last
  return nextULong(until = (last + step - first) / step) * step + first
}

/**
 * Returns a random element from this array using the specified source of randomness.
 *
 * Example:
 * ```Kotlin
 * Random.choice(1, 2, 3, 4, 5) // a number in the range 1..5
 * ```
 * @since 1.1.0
 * @throws NoSuchElementException - if this array is empty.
 * @see Array.random
 */
@JvmName("choiceVararg")
fun <T> Random.choice(vararg elements: T): T = elements.random(this)

/**
 * Returns a random element from this array using the specified source of randomness.
 *
 * Example:
 * ```Kotlin
 * Random.choice(arrayOf(1..5)) // a number in the range 1..5
 * ```
 * @since 1.1.0
 * @throws NoSuchElementException - if this array is empty.
 * @see Array.random
 */
fun <T> Random.choice(array: Array<T>): T =
  array.random(this)

/**
 * Returns a random element from this collection using the specified source of randomness.
 *
 * Example:
 * ```Kotlin
 * Random.choice(listOf(1..5)) // a number in the range 1..5
 * ```
 * @since 1.1.0
 * @throws NoSuchElementException - if this collection is empty.
 * @see Collection.random
 */
fun <T> Random.choice(collection: Collection<T>): T =
  collection.random(this)

/**
 * Returns a random element from this map using the specified source of randomness.
 *
 * Example:
 * ```Kotlin
 * Random.choice(mapOf(1 to 1, 2 to 2, 3 to 3, 4 to 4, 5 to 5)) // a pair from this map
 * ```
 * @since 1.1.0
 * @throws NoSuchElementException - if this map is empty.
 */
inline fun <reified T, K> Random.choice(map: Map<T, K>): Pair<T, K> {
  val choice = map.keys.random(this)
  return Pair(choice, map[choice]!!)
}

/**
 * Returns a random element from this map using the specified source of randomness.
 *
 * Example:
 * ```Kotlin
 * mapOf(1 to 1, 2 to 2, 3 to 3, 4 to 4, 5 to 5).random() // a pair from this map
 * ```
 * @since 1.1.0
 * @throws NoSuchElementException - if this map is empty.
 */
inline fun <reified K, V> Map<K, V>.random(): Pair<K, V> =
  Random.choice(this)

/**
 * Returns a random element from this array using the specified source of randomness,
 * or null if this array is empty.
 *
 * Example:
 * ```Kotlin
 * Random.choiceOrNull(arrayOf(1..5)) // a number in the range 1..5
 * Random.choiceOrNull(arrayOf()) // null
 * ```
 * @since 1.1.0
 * @see Array.randomOrNull
 */
fun <T> Random.choiceOrNull(array: Array<T>): T? =
  array.randomOrNull(this)

/**
 * Returns a random element from this collection using the specified source of randomness,
 * or null if this collection is empty.
 *
 * Example:
 * ```Kotlin
 * Random.choiceOrNull(listOf(1..5)) // a number in the range 1..5
 * Random.choiceOrNull(listOf()) // null
 * ```
 * @since 1.1.0
 * @see Collection.randomOrNull
 */
fun <T> Random.choiceOrNull(collection: Collection<T>): T? =
  collection.randomOrNull(this)

/**
 * Returns a random element from this map using the specified source of randomness,
 * or null if this map is empty.
 *
 * Example:
 * ```Kotlin
 * Random.choice(mapOf(1 to 1, 2 to 2, 3 to 3, 4 to 4, 5 to 5)) // a pair from this map
 * Random.choice(mapOf()) // null
 * ```
 * @since 1.1.0
 */
inline fun <reified T, K> Random.choiceOrNull(map: Map<T, K>): Pair<T, K>? =
  tryCatchNull {
    val choice = map.keys.random(this)
    Pair(choice, map[choice]!!)
  }

/**
 * Returns a random element from this map using the specified source of randomness,
 * or null if this map is empty.
 *
 * Example:
 * ```Kotlin
 * mapOf(1 to 1, 2 to 2, 3 to 3, 4 to 4, 5 to 5).randomOrNull() // a pair from this map
 * mapOf().randomOrNull() // null
 * ```
 * @since 1.1.0
 */
inline fun <reified K, V> Map<K, V>.randomOrNull(): Pair<K, V>? =
  Random.choiceOrNull(this)

/**
 * Returns a random list from this array using the specified source of randomness.
 *
 * @since 1.1.0
 * @throws IllegalArgumentException if this array is empty.
 * @param elements
 * @param weights A list were you can weigh the possibility for each value. (Optional)
 * @param length An integer defining the length of the returned list. (Optional)
 * @return randomness list
 * @see Random.choice
 */
@JvmName("choicesVararg")
@JvmOverloads
fun <T> Random.choices(vararg elements: T, weights: List<Int>? = null, length: Int = 1): List<T> {
  val size = elements.size
  require(elements.isNotEmpty()) { "Arrays is empty." }
  weights?.let { require(it.size == size) { "Weights size must be equals to numbers size" } }
  val randoms = mutableListOf<T>()

  // select element with weight
  if (weights != null) {
    val random = RandomWeight(weights)
    repeat(length) {
      val index = random.pickIndex()
      randoms.add(elements.elementAt(index))
    }
  } else {
    repeat(length) {
      randoms.add(Random.choice(elements))
    }
  }
  return randoms
}

/**
 * Returns a random list from this array using the specified source of randomness.
 *
 * @since 1.1.0
 * @throws IllegalArgumentException if this array is empty.
 * @param array
 * @param weights A list were you can weigh the possibility for each value. (Optional)
 * @param length An integer defining the length of the returned list. (Optional)
 * @return randomness list
 * @see Random.choice
 */
@JvmOverloads
fun <T> Random.choices(array: Array<T>, weights: List<Int>? = null, length: Int = 1): List<T> {
  val size = array.size
  require(array.isNotEmpty()) { "Arrays is empty." }
  weights?.let { require(it.size == size) { "weights size must be equals to numbers size" } }
  val randoms = arrayListOf<T>()

  // select element with weight
  if (weights != null) {
    val random = RandomWeight(weights)
    repeat(length) {
      val index = random.pickIndex()
      randoms.add(array.elementAt(index))
    }
  } else {
    repeat(length) {
      randoms.add(Random.choice(array))
    }
  }
  return randoms
}

/**
 * Returns a random list from this collection using the specified source of randomness.
 *
 * @since 1.1.0
 * @throws IllegalArgumentException if this collection is empty.
 * @param collection
 * @param weights A list were you can weigh the possibility for each value. (Optional)
 * @param length An integer defining the length of the returned list. (Optional)
 * @return randomness list
 * @see Random.choice
 */
@JvmOverloads
fun <T> Random.choices(
  collection: Collection<T>,
  weights: List<Int>? = null,
  length: Int = 1
): List<T> {
  val size = collection.size
  require(collection.isNotEmpty()) { "Collection is empty." }
  weights?.let { require(it.size == size) { "weights size must be equals to numbers size" } }
  val randoms = arrayListOf<T>()

  // select element with weight
  if (weights != null) {
    val random = RandomWeight(weights)
    repeat(length) {
      val index = random.pickIndex()
      randoms.add(collection.elementAt(index))
    }
  } else {
    repeat(length) {
      randoms.add(Random.choice(collection))
    }
  }
  return randoms
}

/**
 * Returns a random list from this array using the specified source of randomness,
 * or null if this array is empty.
 *
 * @since 1.1.0
 * @param array
 * @param weights A list were you can weigh the possibility for each value. (Optional)
 * @param length An integer defining the length of the returned list. (Optional)
 * @return randomness list
 * @see Random.choice
 */
@JvmOverloads
fun <T> Random.choicesOrNull(
  array: Array<T>,
  weights: List<Int>? = null,
  length: Int = 1
): List<T>? = tryCatchNull {
  choices(array, weights, length)
}

/**
 * Returns a random list from this collection using the specified source of randomness,
 * or null if this collection is empty.
 *
 * @since 1.1.0
 * @param collection
 * @param weights A list were you can weigh the possibility for each value. (Optional)
 * @param length An integer defining the length of the returned list. (Optional)
 * @return randomness list
 * @see Random.choice
 */
@JvmOverloads
fun <T> Random.choicesOrNull(
  collection: Collection<T>,
  weights: List<Int>? = null,
  length: Int = 1
): List<T>? = tryCatchNull {
  choices(collection, weights, length)
}
