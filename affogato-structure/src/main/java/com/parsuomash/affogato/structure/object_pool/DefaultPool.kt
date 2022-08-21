package com.parsuomash.affogato.structure.object_pool

/**
 * # Object Pool Design Pattern
 * The pool stores commonly used objects that must be created throughout the project
 * and take a long time to build.
 *
 * Example:
 * ```kotlin
 * DefaultPool["key"] = value
 * ```
 * @since 1.4.0
 * @see ObjectPool
 */
object DefaultPool : ObjectPool<Any>()

/**
 * # Boolean Pool
 * The boolean pool stores commonly used [Boolean] that must be created throughout the project
 * and take a long time to build.
 *
 * Example:
 * ```kotlin
 * BooleanPool["key"] = true
 * ```
 * @since 1.4.0
 * @see ObjectPool
 */
object BooleanPool : ObjectPool<Boolean>()

/**
 * # Int Pool
 * The int pool stores commonly used [Int] that must be created throughout the project
 * and take a long time to build.
 *
 * Example:
 * ```kotlin
 * IntPool["key"] = 0
 * ```
 * @since 1.4.0
 * @see ObjectPool
 */
object IntPool : ObjectPool<Int>()

/**
 * # Long Pool
 * The long pool stores commonly used [Long] that must be created throughout the project
 * and take a long time to build.
 *
 * Example:
 * ```kotlin
 * LongPool["key"] = 1L
 * ```
 * @since 1.4.0
 * @see ObjectPool
 */
object LongPool : ObjectPool<Long>()

/**
 * # Float Pool
 * The float pool stores commonly used [Float] that must be created throughout the project
 * and take a long time to build.
 *
 * Example:
 * ```kotlin
 * FloatPool["key"] = 1F
 * ```
 * @since 1.4.0
 * @see ObjectPool
 */
object FloatPool : ObjectPool<Float>()

/**
 * # Double Pool
 * The double pool stores commonly used [Double] that must be created throughout the project
 * and take a long time to build.
 *
 * Example:
 * ```kotlin
 * DoublePool["key"] = 1.0
 * ```
 * @since 1.4.0
 * @see ObjectPool
 */
object DoublePool : ObjectPool<Double>()

/**
 * # String Pool
 * The string pool stores commonly used [String] that must be created throughout the project
 * and take a long time to build.
 *
 * Example:
 * ```kotlin
 * StringPool["key"] = "word"
 * ```
 * @since 1.4.0
 * @see ObjectPool
 */
object StringPool : ObjectPool<String>()
