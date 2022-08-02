@file:Suppress("unused")

package com.parsuomash.affogato.core.ktx

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
