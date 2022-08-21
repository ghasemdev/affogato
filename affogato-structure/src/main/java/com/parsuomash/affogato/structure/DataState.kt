@file:Suppress("unused")

package com.parsuomash.affogato.structure

/**
 * DataState Contains three different state:
 * + Success : returned data
 * + Error   : thrown exception
 * + Loading : initialize state
 *
 * Example:
 * ```kotlin
 * fun main() {
 *   val state: DataState<Int> = DataState.Success(1)
 *   when (state) {
 *     is DataState.Success -> println(state.data)
 *     is DataState.Error -> println(state.exception)
 *     is DataState.Loading -> println("Loading")
 *   }
 * }
 * ```
 * @since 1.3.0
 */
sealed interface DataState<out R> {
  data class Success<T>(val data: T) : DataState<T>
  data class Error(val exception: Exception) : DataState<Nothing>
  object Loading : DataState<Nothing>
}
