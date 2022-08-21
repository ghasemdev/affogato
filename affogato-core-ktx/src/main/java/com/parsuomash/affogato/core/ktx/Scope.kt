package com.parsuomash.affogato.core.ktx

/**
 * Return the value before run the execution block.
 *
 * Example:
 * ```Kotlin
 * var value = "Hello"
 * val blockString = value.runBlock { string += " World" }
 * blockString // "Hello"
 * value //Hello World"
 * ```
 * @since 1.4.0
 * @see run
 * @see with
 * @see apply
 * @see let
 * @see also
 */
inline fun <T> T.runBlock(block: () -> Unit): T {
  val old = this
  block()
  return old
}

// TODO v2.0.0 remove deprecated functions ---------------------------------------------------------

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
@Deprecated(
  message = "This function is deprecated and will be removed in next major release." +
    "Use runBlock() instead.",
  replaceWith = ReplaceWith(
    expression = "runBlock(block)",
    imports = ["com.parsuomash.affogato.core.ktx.runBlock"]
  ),
  level = DeprecationLevel.WARNING
)
inline fun <T> T.block(block: () -> Unit): T {
  val old = this
  block()
  return old
}
