package com.parsuomash.affogato.core.ktx

/**
 * Return the value before run the execution block.
 *
 * Example:
 * ```Kotlin
 * var value = "Hello"
 * val blockString = value.block { string += " World" }
 * blockString // "Hello"
 * value //Hello World"
 * ```
 * @since 1.1.0
 * @see run
 * @see with
 * @see apply
 * @see let
 * @see also
 */
inline fun <T> T.block(block: () -> Unit): T {
  val old = this
  block()
  return old
}
