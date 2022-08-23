package com.parsuomash.affogato.coroutines.core

import com.parsuomash.affogato.core.ktx.tryCatchBool
import com.parsuomash.affogato.core.ktx.tryCatchBoolean
import com.parsuomash.affogato.core.ktx.tryCatchElse
import com.parsuomash.affogato.core.ktx.tryCatchIgnore
import com.parsuomash.affogato.core.ktx.tryCatchNull
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * suspendedTryCatchIgnore used when you want to ignore catch block if an exception is thrown
 * in suspend functions.
 *
 * Example:
 * ```Kotlin
 * suspend fun foo() = suspendedTryCatchIgnore {
 *   // do something
 * }
 * ```
 * @since 1.2.0
 * @see tryCatchIgnore
 */
@JvmSynthetic
suspend inline fun <T> suspendedTryCatchIgnore(
  context: CoroutineContext = Dispatchers.Default,
  crossinline block: suspend () -> T
) {
  withContext(context) { tryCatchIgnore { block() } }
}

/**
 * suspendedTryCatchBoolean used when you want to return false if an exception is thrown
 * in suspend functions.
 *
 * Example:
 * ```Kotlin
 * suspend fun foo() = suspendedTryCatchBoolean {
 *   // do something
 * }
 * ```
 * @since 1.2.0
 * @see tryCatchBoolean
 * @see suspendedTryCatchBool
 */
@JvmSynthetic
suspend inline fun suspendedTryCatchBoolean(
  context: CoroutineContext = Dispatchers.Default,
  crossinline block: suspend () -> Unit
): Boolean = withContext(context) { tryCatchBoolean { block() } }

/**
 * suspendedTryCatchBool used when you want to return a boolean value or return false
 * if an exception is thrown in suspend functions.
 *
 * Example:
 * ```Kotlin
 * suspend fun foo() = suspendedTryCatchBool {
 *   // do something to return a boolean value
 * }
 * ```
 * @since 1.2.0
 * @see tryCatchBool
 * @see suspendedTryCatchBoolean
 */
@JvmSynthetic
suspend inline fun suspendedTryCatchBool(
  context: CoroutineContext = Dispatchers.Default,
  crossinline block: suspend () -> Boolean
): Boolean = withContext(context) { tryCatchBool { block() } }

/**
 * suspendedTryCatchNull used when you want to return null if an exception is thrown in
 * suspend functions.
 *
 * Example:
 * ```Kotlin
 * suspend fun foo() = suspendedTryCatchNull {
 *   // do something to return a value
 * }
 * ```
 * @since 1.2.0
 * @see tryCatchNull
 */
@JvmSynthetic
suspend inline fun <T> suspendedTryCatchNull(
  context: CoroutineContext = Dispatchers.Default,
  crossinline block: suspend () -> T
): T? = withContext(context) { tryCatchNull { block() } }

/**
 * suspendedTryCatchElse used when you want to return a default value if an exception is thrown in
 * suspend functions.
 *
 * Example:
 * ```Kotlin
 * suspend fun foo() = suspendedTryCatchElse({ // do else to return a value }) {
 *   // do something to return a value
 * }
 * ```
 * @since 1.2.0
 * @see tryCatchElse
 */
@JvmSynthetic
suspend inline fun <T> suspendedTryCatchElse(
  context: CoroutineContext = Dispatchers.Default,
  crossinline elseBlock: suspend () -> T,
  crossinline block: suspend () -> T
): T = withContext(context) { tryCatchElse({ elseBlock() }, { block() }) }
