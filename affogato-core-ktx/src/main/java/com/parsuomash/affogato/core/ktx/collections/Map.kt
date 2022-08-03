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
