package com.parsuomash.affogato.structure.object_pool

import com.parsuomash.affogato.core.ktx.orDefault

/**
 * This class define a simple template of object pool pattern.
 *
 * Example:
 * ```kotlin
 * val customPool = ObjectPool<Int>()
 * ```
 * @since 1.4.0
 */
open class ObjectPool<T> {
  var objects = hashMapOf<String, T>()
    private set

  /**
   * Pool size
   * @since 1.4.0
   */
  val size: Int
    get() = objects.size

  /**
   * Returns the value for the given [key] or throws an exception if there is no such key in
   * the pool.
   * @since 1.4.0
   * @throws NoSuchElementException if pool is empty.
   * @see getOrNull
   * @see getOrElse
   */
  operator fun get(key: String): T {
    if (objects.isEmpty()) throw NoSuchElementException("Pool is empty!")
    return objects.getValue(key)
  }

  /**
   * Returns the value to which the specified [key] is mapped, or null if this pool
   * contains no mapping for the [key].
   * @since 1.4.0
   * @see get
   * @see getOrElse
   */
  fun getOrNull(key: String): T? =
    objects[key]

  /**
   * Returns the value for the given [key], or the result of the [defaultValue] function if there
   * was no entry for the given key.
   * @since 1.4.0
   * @see get
   * @see getOrNull
   */
  fun getOrElse(key: String, defaultValue: () -> T): T =
    objects.getOrElse(key, defaultValue)

  /**
   * Returns the last value or throws an exception if pool is empty.
   * @since 1.4.0
   * @throws NoSuchElementException if pool is empty.
   * @see lastOrNull
   * @see lastOrElse
   */
  fun last(): T {
    if (objects.isEmpty()) throw NoSuchElementException("Pool is empty!")
    return objects.values.last()
  }

  /**
   * Returns the last value, or null if this pool contains no entry.
   * @since 1.4.0
   * @see last
   * @see lastOrElse
   */
  fun lastOrNull(): T? =
    objects.values.lastOrNull()

  /**
   * Returns the last value, or the result of the [defaultValue] function if there was no entry.
   * @since 1.4.0
   * @see last
   * @see lastOrNull
   */
  fun lastOrElse(defaultValue: () -> T): T =
    objects.values.lastOrNull().orDefault(defaultValue())

  /**
   * Returns the first value or throws an exception if pool is empty.
   * @since 1.4.0
   * @throws NoSuchElementException if pool is empty.
   * @see firstOrNull
   * @see firstOrElse
   */
  fun first(): T {
    if (objects.isEmpty()) throw NoSuchElementException("Pool is empty!")
    return objects.values.first()
  }

  /**
   * Returns the first value, or null if this pool contains no entry.
   * @since 1.4.0
   * @see first
   * @see firstOrElse
   */
  fun firstOrNull(): T? =
    objects.values.firstOrNull()

  /**
   * Returns the first value, or the result of the [defaultValue] function if there was no entry.
   * @since 1.4.0
   * @see first
   * @see firstOrNull
   */
  fun firstOrElse(defaultValue: () -> T): T =
    objects.values.firstOrNull().orDefault(defaultValue())

  /**
   * Allows to use the index operator for storing values in a pool.
   * @since 1.4.0
   */
  operator fun set(key: String, value: T) {
    objects[key] = value
  }
}
