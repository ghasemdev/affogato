package com.parsuomash.affogato.core.ktx.collections

import com.parsuomash.affogato.core.ktx.tryCatchElse
import com.parsuomash.affogato.core.ktx.tryCatchNull

/**
 * Returns the last index of [Collection].
 *
 * Example:
 * ```Kotlin
 * listOf(1..10).lastIndex // 9
 * ```
 * @since 1.1.0
 */
inline val <T> Collection<T>.lastIndex: Int get() = size - 1

/**
 * Returns an element at the given index or empty
 * if the index is out of bounds of this string [Collection].
 *
 * Example:
 * ```Kotlin
 * val list = listOf(1..5)
 * list.getOrEmpty(8) // ""
 * list[2] // 3
 * ```
 * @since 1.1.0
 * @see listOf
 */
fun Collection<String>.getOrEmpty(index: Int): String =
  if (index in 0..lastIndex) toList()[index] else ""

/**
 * Returns a [ArrayList] containing all elements.
 *
 * Example:
 * ```Kotlin
 * (1..10).toArrayList() // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * ```
 * @since 1.1.0
 */
inline fun <reified T> Iterable<T>.toArrayList(): ArrayList<T> = ArrayList(toList())

/**
 * Returns a [LinkedList] containing all elements.
 *
 * Example:
 * ```Kotlin
 * (1..10).toLinkedList() // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * ```
 * @since 1.1.0
 */
inline fun <reified T> Iterable<T>.toLinkedList(): LinkedList<T> = LinkedList(toList())

/**
 * Returns the sub-list from the given range.
 *
 * Example:
 * ```Kotlin
 * listOf(1..10)[0..4] // [1, 2, 3, 4, 5]
 * ```
 * @since 1.1.0
 * @throws IndexOutOfBoundsException if the range is out of bounds of the array.
 * @see slice
 * @see listOf
 */
inline operator fun <reified T> Iterable<T>.get(indices: IntRange): List<T> =
  toList().slice(indices)

/**
 * Returns the sub-list from the given progression.
 *
 * Example:
 * ```Kotlin
 * listOf(1..10)[0..9 step 2] // [1, 3, 5, 7, 9]
 * ```
 * @since 1.1.0
 * @throws IndexOutOfBoundsException if the range is out of bounds of the array.
 * @see slice
 * @see listOf
 */
inline operator fun <reified T> Iterable<T>.get(indices: IntProgression): List<T> =
  toList().slice(indices)

/**
 * Returns the sub-listOf from the given range if exist otherwise return a null.
 *
 * Example:
 * ```Kotlin
 * listOf(1..10).getOrNull(0..4)!! // [1, 2, 3, 4, 5]
 * listOf(1..10).getOrNull(10..14) // null
 * ```
 * @since 1.1.0
 * @see slice
 * @see listOf
 */
inline fun <reified T> Iterable<T>.getOrNull(indices: IntRange): List<T>? =
  tryCatchNull { get(indices) }

/**
 * Returns the sub-list from the given progression if exist otherwise return a null.
 *
 * Example:
 * ```Kotlin
 * listOf(1..10).getOrNull(0..9 step 2)!! // [1, 3, 5, 7, 9]
 * listOf(1..10).getOrNull(10..14 step 2) // null
 * ```
 * @since 1.1.0
 * @see slice
 * @see listOf
 */
inline fun <reified T> Iterable<T>.getOrNull(indices: IntProgression): List<T>? =
  tryCatchNull { get(indices) }

/**
 * Returns the sub-list from the given range if exist otherwise return else block.
 *
 * Example:
 * ```Kotlin
 * listOf(1..10).getOrElse(0..4) { arrayOf(1) } // [1, 2, 3, 4, 5]
 * listOf(1..10).getOrElse(10..14) { arrayOf(1) } // [1]
 * ```
 * @since 1.1.0
 * @see slice
 * @see listOf
 */
inline fun <reified T> Iterable<T>.getOrElse(
  indices: IntRange,
  defaultValue: () -> List<T>
): List<T> = tryCatchElse({ defaultValue() }) { get(indices) }

/**
 * Returns the sub-list from the given progression if exist otherwise return else block.
 *
 * Example:
 * ```Kotlin
 * listOf(1..10).getOrElse(0..9 step 2) { arrayOf(1) } // [1, 3, 5, 7, 9]
 * listOf(1..10).getOrElse(10..14 step 2) { arrayOf(1) } // [1]
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see slice
 */
inline fun <reified T> Iterable<T>.getOrElse(
  indices: IntProgression,
  defaultValue: () -> List<T>
): List<T> = tryCatchElse({ defaultValue() }) { get(indices) }

/**
 * Returns a list containing first [n] elements.
 *
 * Example:
 * ```Kotlin
 * listOf(1..10).head(3) // [1, 2, 3]
 * ```
 * @since 1.1.0
 * @param n number of elements return
 * @throws IllegalArgumentException if n is negative.
 * @return sublist
 * @see take
 * @see listOf
 */
inline fun <reified T> Iterable<T>.head(n: Int = 10): List<T> = take(n)

/**
 * Returns a list containing last [n] elements.
 *
 * Example:
 * ```Kotlin
 * listOf(1..10).tail(3) // [8, 9, 10]
 * ```
 * @since 1.1.0
 * @param n number of elements return
 * @throws IllegalArgumentException if n is negative.
 * @return sublist
 * @see drop
 * @see listOf
 */
inline fun <reified T> Iterable<T>.tail(n: Int = 10): List<T> = with(toList()) {
  (size - n).let { drop(if (it < 0) 0 else it) }
}

/**
 * finds two numbers inside the [Iterable] from the given sum.
 *
 * Example:
 * ```Kotlin
 * listOf(1..10).findPairOfSum(10) // (1, 9)
 * ```
 * @since 1.1.0
 * @see listOf
 */
fun Iterable<Int>.findPairOfSum(sum: Int): Pair<Int, Int>? {
  val complements = associateBy { sum - it }
  for (element in this) {
    val complement = complements[element]
    val result = complement?.let { Pair(element, complement) }
    if (result != null) {
      return result
    }
  }
  return null
}

/**
 * finds two numbers inside the [Iterable] from the given sum.
 *
 * Example:
 * ```Kotlin
 * listOf(1..10L).findPairOfSum(10L) // (1L, 9L)
 * ```
 * @since 1.1.0
 * @see listOf
 */
fun Iterable<Long>.findPairOfSum(sum: Long): Pair<Long, Long>? {
  val complements = associateBy { sum - it }
  for (element in this) {
    val complement = complements[element]
    val result = complement?.let { Pair(element, complement) }
    if (result != null) {
      return result
    }
  }
  return null
}

/**
 * finds two numbers inside the [Iterable] from the given sum.
 *
 * Example:
 * ```Kotlin
 * listOf(1F, 2F, 3F, 4F, 5F).findPairOfSum(3F) // (1F, 2F)
 * ```
 * @since 1.1.0
 * @see listOf
 */
fun Iterable<Float>.findPairOfSum(sum: Float): Pair<Float, Float>? {
  val complements = associateBy { sum - it }
  for (element in this) {
    val complement = complements[element]
    val result = complement?.let { Pair(element, complement) }
    if (result != null) {
      return result
    }
  }
  return null
}

/**
 * finds two numbers inside the [Iterable] from the given sum.
 *
 * Example:
 * ```Kotlin
 * listOf(1.0, 2.0, 3.0, 4.0, 5.0).findPairOfSum(3.0) // (1.0, 2.0)
 * ```
 * @since 1.1.0
 * @see listOf
 */
fun Iterable<Double>.findPairOfSum(sum: Double): Pair<Double, Double>? {
  val complements = associateBy { sum - it }
  for (element in this) {
    val complement = complements[element]
    val result = complement?.let { Pair(element, complement) }
    if (result != null) {
      return result
    }
  }
  return null
}

/**
 * finds three numbers inside the [Iterable] from the given sum.
 *
 * Example:
 * ```Kotlin
 * listOf(1..10).findTripleOfSum(6) // (1, 2, 3)
 * ```
 * @since 1.1.0
 * @see listOf
 */
fun Iterable<Int>.findTripleOfSum(sum: Int): Triple<Int, Int, Int>? {
  for (x in this) {
    // x -> (y, z) where y + z = sum - x
    val pair = findPairOfSum(sum - x)
    val result = pair?.let { Triple(x, pair.first, pair.second) }
    if (result != null) {
      return result
    }
  }
  return null
}

/**
 * finds three numbers inside the [Iterable] from the given sum.
 *
 * Example:
 * ```Kotlin
 * listOf(1..10L).findTripleOfSum(6L) // (1L, 2L, 3L)
 * ```
 * @since 1.1.0
 * @see listOf
 */
fun Iterable<Long>.findTripleOfSum(sum: Long): Triple<Long, Long, Long>? {
  for (x in this) {
    // x -> (y, z) where y + z = sum - x
    val pair = findPairOfSum(sum - x)
    val result = pair?.let { Triple(x, pair.first, pair.second) }
    if (result != null) {
      return result
    }
  }
  return null
}

/**
 * finds three numbers inside the [Iterable] from the given sum.
 *
 * Example:
 * ```Kotlin
 * listOf(1F, 2F, 3F, 4F, 5F, 6F).findTripleOfSum(6F) // (1F, 2F, 3F)
 * ```
 * @since 1.1.0
 * @see listOf
 */
fun Iterable<Float>.findTripleOfSum(sum: Float): Triple<Float, Float, Float>? {
  for (x in this) {
    // x -> (y, z) where y + z = sum - x
    val pair = findPairOfSum(sum - x)
    val result = pair?.let { Triple(x, pair.first, pair.second) }
    if (result != null) {
      return result
    }
  }
  return null
}

/**
 * finds three numbers inside the [Iterable] from the given sum.
 *
 * Example:
 * ```Kotlin
 * listOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0).findTripleOfSum(6.0) // (1.0, 2.0, 3.0)
 * ```
 * @since 1.1.0
 * @see listOf
 */
fun Iterable<Double>.findTripleOfSum(sum: Double): Triple<Double, Double, Double>? {
  for (x in this) {
    // x -> (y, z) where y + z = sum - x
    val pair = findPairOfSum(sum - x)
    val result = pair?.let { Triple(x, pair.first, pair.second) }
    if (result != null) {
      return result
    }
  }
  return null
}

/**
 * Rotates the [Iterable] to the left by specified distance.
 *
 * Example:
 * ```Kotlin
 * listOf(1, 2, 3, 4, 5).rotateLeft(2) // [4, 5, 1, 2, 3]
 * ```
 * @since 1.1.0
 * @param n number of elements rotate
 * @throws IllegalArgumentException if n is **negative** or **zero**.
 * @see java.util.Collections.rotate
 * @see listOf
 */
inline fun <reified T> Iterable<T>.rotateLeft(n: Int = 1): List<T> {
  require(n >= 1) { "n must be >= 1" }
  val list = this.toMutableList()
  Collections.rotate(list, n)
  return list
}

/**
 * Rotates the [Iterable] to the right by specified distance.
 *
 * Example:
 * ```Kotlin
 * listOf(1, 2, 3, 4, 5).rotateRight(2) // [3, 4, 5, 1, 2]
 * ```
 * @since 1.1.0
 * @param n number of elements rotate
 * @throws IllegalArgumentException if n is **negative** or **zero**.
 * @see java.util.Collections.rotate
 * @see listOf
 */
inline fun <reified T> Iterable<T>.rotateRight(n: Int = 1): List<T> {
  require(n >= 1) { "n must be >= 1" }
  val list = this.toMutableList()
  Collections.rotate(list, -n)
  return list
}
