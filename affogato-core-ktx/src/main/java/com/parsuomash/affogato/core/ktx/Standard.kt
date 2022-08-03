package com.parsuomash.affogato.core.ktx

/**
 * Calculate count of each value by group in the string.
 *
 * Example:
 * ```Kotlin
 * val value = "aba"
 * counter(value) // { a = 2, b = 1 }
 * ```
 * @since 1.1.0
 * @see groupingBy
 * @see eachCount
 */
fun counter(content: String) = content.groupingBy { it }.eachCount()

/**
 * Calculate count of each value by group in the Array.
 *
 * Example:
 * ```Kotlin
 * val value = arrayOf("a", "b", "a")
 * counter(value) // { a = 2, b = 1 }
 * ```
 * @since 1.1.0
 * @see groupingBy
 * @see eachCount
 * @see arrayOf
 */
fun <T> counter(content: Array<T>) = content.groupingBy { it }.eachCount()

/**
 * Calculate count of each value by group in the byte array.
 *
 * Example:
 * ```Kotlin
 * val value = byteArrayOf(1, 2, 1)
 * counter(value) // { 1 = 2, 2 = 1 }
 * ```
 * @since 1.1.0
 * @see groupingBy
 * @see eachCount
 * @see byteArrayOf
 */
fun counter(content: ByteArray) = content.toList().groupingBy { it }.eachCount()

/**
 * Calculate count of each value by group in the char array.
 *
 * Example:
 * ```Kotlin
 * val value = charArrayOf('a', 'b', 'a')
 * counter(value) // { a = 2, b = 1 }
 * ```
 * @since 1.1.0
 * @see groupingBy
 * @see eachCount
 * @see charArrayOf
 */
fun counter(content: CharArray) = content.toList().groupingBy { it }.eachCount()

/**
 * Calculate count of each value by group in the short array.
 *
 * Example:
 * ```Kotlin
 * val value = shortArrayOf(1, 2, 1)
 * counter(value) // { 1 = 2, 2 = 1 }
 * ```
 * @since 1.1.0
 * @see groupingBy
 * @see eachCount
 * @see shortArrayOf
 */
fun counter(content: ShortArray) = content.toList().groupingBy { it }.eachCount()

/**
 * Calculate count of each value by group in the int array.
 *
 * Example:
 * ```Kotlin
 * val value = intArrayOf(1, 2, 1)
 * counter(value) // { a = 2, b = 1 }
 * ```
 * @since 1.1.0
 * @see groupingBy
 * @see eachCount
 * @see intArrayOf
 */
fun counter(content: IntArray) = content.toList().groupingBy { it }.eachCount()

/**
 * Calculate count of each value by group in the long array.
 *
 * Example:
 * ```Kotlin
 * val value = longArrayOf(1L, 2L, 1L)
 * counter(value) // { 1L = 2, 2L = 1 }
 * ```
 * @since 1.1.0
 * @see groupingBy
 * @see eachCount
 * @see longArrayOf
 */
fun counter(content: LongArray) = content.toList().groupingBy { it }.eachCount()

/**
 * Calculate count of each value by group in the float array.
 *
 * Example:
 * ```Kotlin
 * val value = floatArrayOf(1F, 2F, 1F)
 * counter(value) // { 1F = 2, 2F = 1 }
 * ```
 * @since 1.1.0
 * @see groupingBy
 * @see eachCount
 * @see floatArrayOf
 */
fun counter(content: FloatArray) = content.toList().groupingBy { it }.eachCount()

/**
 * Calculate count of each value by group in the double array.
 *
 * Example:
 * ```Kotlin
 * val value = doubleArrayOf(1.0, 2.0, 1.0)
 * counter(value) // { 1.0 = 2, 2.0 = 1 }
 * ```
 * @since 1.1.0
 * @see groupingBy
 * @see eachCount
 * @see doubleArrayOf
 */
fun counter(content: DoubleArray) = content.toList().groupingBy { it }.eachCount()

/**
 * Calculate count of each value by group in the boolean array.
 *
 * Example:
 * ```Kotlin
 * val value = booleanArrayOf(false, true, false)
 * counter(value) // { false 2, true = 1 }
 * ```
 * @since 1.1.0
 * @see groupingBy
 * @see eachCount
 * @see booleanArrayOf
 */
fun counter(content: BooleanArray) = content.toList().groupingBy { it }.eachCount()

/**
 * Calculate count of each value by group in the iterable.
 *
 * Example:
 * ```Kotlin
 * val value = listOf("a", "b", "a")
 * counter(value) // { a = 2, b = 1 }
 * ```
 * @since 1.1.0
 * @see groupingBy
 * @see eachCount
 * @see listOf
 */
fun <T> counter(content: Iterable<T>) = content.groupingBy { it }.eachCount()

/**
 * when variable is null default value maintained.
 *
 * Example:
 * ```Kotlin
 * val str: String? = null
 * str.orDefault("def") // def
 * ```
 * @since 1.1.0
 * @return [T] value or **default**
 */
fun <T> T?.orDefault(default: T): T = this ?: default

/**
 * Checking nullability.
 *
 * Example:
 * ```Kotlin
 * val text: String? = null
 * text.isNull() // true
 *
 * val text2 = "hi"
 * text2.isNull() // false
 * ```
 * @since 1.1.0
 * @return [Boolean]
 */
fun <T> T?.isNull(): Boolean = this == null

/**
 * Checking none nullability.
 *
 * Example:
 * ```Kotlin
 * val text: String? = null
 * text.isNotNull() // false
 *
 * val text2 = "hi"
 * text2.isNotNull() // true
 * ```
 * @since 1.1.0
 * @return [Boolean]
 */
fun <T> T?.isNotNull(): Boolean = this != null

/**
 * ifNull execute when value is null.
 *
 * Example:
 * ```Kotlin
 * val value: String? = null
 * value.ifNull { ... } // Unit
 * value.ifNull {
 *   ...
 *   "i am not null"
 * } // i am not null
 *
 * val value2 = "hello"
 * value2.ifNull { ... } // hello
 * value2.ifNull {
 *   ...
 *   "i am not null"
 * } // hello
 * ```
 * @since 1.1.0
 * @return value or [Unit]
 */
inline fun <T> T?.ifNull(block: (T?) -> Any): Any = this ?: block(this)

/**
 * ifNotNull execute when value isn't null.
 *
 * Example:
 * ```Kotlin
 * val value: String? = null
 * value.ifNotNull { ... } // null
 * value.ifNotNull {
 *   ...
 *   "i am not null"
 * } // null
 *
 * val value2 = "hello"
 * value2.ifNotNull { ... } // Unit
 * value2.ifNotNull {
 *   ...
 *   "i am not null"
 * } // i am not null
 * ```
 * @since 1.1.0
 * @return value or [Unit]
 */
inline fun <T, R> T?.ifNotNull(block: (T) -> R): R? = if (this != null) block(this) else this

/**
 * Sometimes we need try-catch block without error handling.
 *
 * Example:
 * ```Kotlin
 * tryCatchIgnore {
 *   ...
 *   throw Exception("throw")
 * }
 * ```
 * @since 1.1.0
 */
inline fun tryCatchIgnore(block: () -> Unit) {
  try {
    block()
  } catch (_: Exception) {
  }
}

/**
 * When try-catch block failed return false otherwise true.
 *
 * Example:
 * ```Kotlin
 * tryCatchBoolean {
 *   ...
 *   throw Exception("throw")
 * } // false
 *
 * tryCatchBoolean {
 *   ...
 * } // true
 * ```
 * @since 1.1.0
 */
inline fun tryCatchBoolean(block: () -> Unit): Boolean {
  return try {
    block()
    true
  } catch (_: Exception) {
    false
  }
}

/**
 * When try-catch block failed return null otherwise latest value.
 *
 * Example:
 * ```Kotlin
 * tryCatchNull {
 *   throw Exception("throw")
 *   num++
 * } // null
 *
 * tryCatchNull {
 *   var num = 0
 *   ++num
 * } // 1
 * ```
 * @since 1.1.0
 */
inline fun <T> tryCatchNull(block: () -> T): T? {
  return try {
    block()
  } catch (_: Exception) {
    null
  }
}

/**
 * When try-catch block failed return else block otherwise try block.
 *
 * Example:
 * ```Kotlin
 * var num = 0
 * tryCatchElse(elseBlock = { --num }) {
 *   throw Exception("throw")
 *   num++
 * } // -1
 *
 * tryCatchElse(elseBlock = { --num }) {
 *   ++num
 * } // 0
 * ```
 * @since 1.1.0
 */
inline fun <T> tryCatchElse(elseBlock: () -> T, block: () -> T): T {
  return try {
    block()
  } catch (_: Exception) {
    elseBlock()
  }
}
