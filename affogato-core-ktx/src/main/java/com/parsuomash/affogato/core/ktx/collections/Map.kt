package com.parsuomash.affogato.core.ktx.collections

/**
 * Returns a [HashMap] containing all elements.
 *
 * Example:
 * ```Kotlin
 * mapOf(1 to 2, 2 to 3).toHashMap() // {1=2, 2=3}
 * ```
 * @since 1.1.0
 */
inline fun <reified K, V> Map<K, V>.toHashMap(): HashMap<K, V> = HashMap(this)

/**
 * Returns a [LinkedHashMap] containing all elements.
 *
 * Example:
 * ```Kotlin
 * mapOf(1 to 2, 2 to 3).toLinkedMap() // {1=2, 2=3}
 * ```
 * @since 1.1.0
 */
inline fun <reified K, V> Map<K, V>.toLinkedMap(): LinkedHashMap<K, V> = LinkedHashMap(this)

/**
 * Returns a map of all elements sorted by value.
 *
 * Example:
 * ```Kotlin
 * mapOf(5 to 1, 10 to 10, 1 to 0).sortedByValue() // {1:0, 5:1, 10:10}
 * mapOf("11" to 1, "1" to 10, "a" to 0).sortedByValue() // {"1":10, "11":1, "a":0}
 * ```
 * @since 1.1.0
 */
inline fun <reified K, V> Map<K, V>.sortedByValue(): Map<K, V> =
  toList().sortedBy { it.second.hashCode() }.toMap()

/**
 * Returns a map of all elements sorted by dec value.
 *
 * Example:
 * ```Kotlin
 * mapOf(5 to 1, 10 to 10, 1 to 0).sortedByValueDescending() // {10:10, 5:1, 1:0}
 * mapOf("11" to 1, "1" to 10, "a" to 0).sortedByValueDescending() // {"a":0, "11":1, "1":10}
 * ```
 * @since 1.1.0
 */
inline fun <reified K, V> Map<K, V>.sortedByValueDescending(): Map<K, V> =
  toList().sortedByDescending { it.second.hashCode() }.toMap()

/**
 * Returns a map of all elements sorted by key.
 *
 * Example:
 * ```Kotlin
 * mapOf(1 to 0, 5 to 1, 10 to 10, 7 to 0).sortedByKey()
 * // {1:0, 7:0, 5:1, 10:10}
 * mapOf(1 to "a", 2 to "0", 3 to "11", 4 to "01", 5 to "1").sortedByKey()
 * // {2:"0", 4:"01", 5:"1", 3:"11", 1:"a"}
 * ```
 * @since 1.1.0
 */
inline fun <reified K, V> Map<K, V>.sortedByKey(): Map<K, V> =
  toList().sortedBy { it.first.hashCode() }.toMap()

/**
 * Returns a map of all elements sorted by dec key.
 *
 * Example:
 * ```Kotlin
 * mapOf(1 to 0, 5 to 1, 10 to 10, 7 to 0).sortedByKeyDescending()
 * // {10:10, 5:1, 1:0, 7:0}
 * mapOf(2 to "0", 3 to "11", 4 to "01", 5 to "1").sortedByKeyDescending()
 * // {3:"11", 5:"1", 4:"01", 2:"0"}
 * ```
 * @since 1.1.0
 */
inline fun <reified K, V> Map<K, V>.sortedByKeyDescending(): Map<K, V> =
  toList().sortedByDescending { it.first.hashCode() }.toMap()
