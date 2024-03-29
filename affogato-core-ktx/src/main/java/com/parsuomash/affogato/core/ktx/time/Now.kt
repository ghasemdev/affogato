package com.parsuomash.affogato.core.ktx.time

import com.parsuomash.affogato.core.ktx.datetime.now
import com.parsuomash.affogato.core.ktx.datetime.toCalendar
import com.parsuomash.affogato.core.ktx.datetime.toDate
import java.util.*
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone

/**
 * Get current time in [Instant].
 *
 * Example:
 * ```Kotlin
 * now() // 2022-10-08T00:12:00Z
 * ```
 * @since 1.1.0
 * @see Clock
 */
@JvmSynthetic
fun now(): Instant = Clock.System.now()

/**
 * Get current time in milliseconds.
 *
 * Example:
 * ```Kotlin
 * nowInMilliseconds() // 1599984000000
 * ```
 * @since 1.1.0
 * @see now
 */
fun nowInMilliseconds(): Long = now().toEpochMilliseconds()

/**
 * Get current [Date].
 *
 * Example:
 * ```Kotlin
 * nowInDate() // Sun Oct 08 00:12:00 UTC 2022
 * ```
 * @since 1.1.0
 * @see nowInMilliseconds
 */
fun nowInDate(): Date = nowInMilliseconds().toDate()

/**
 * Get current time in [Calendar] format.
 *
 * Example:
 * ```Kotlin
 * nowInCalendar()
 * ```
 * @since 1.1.0
 * @see nowInMilliseconds
 */
fun nowInCalendar(): Calendar = nowInMilliseconds().toCalendar()

/**
 * Get current [LocalDate].
 *
 * Example:
 * ```Kotlin
 * nowInLocalDate() // 2022-10-08
 * ```
 * @since 1.1.0
 * @see LocalDate.Companion.now
 */
@JvmSynthetic
fun nowInLocalDate(timeZone: TimeZone = TimeZone.currentSystemDefault()): LocalDate =
  LocalDate.now(timeZone)

/**
 * Get current [LocalTime].
 *
 * Example:
 * ```Kotlin
 * nowInLocalTime() // 22:35:13.316474400
 * ```
 * @since 1.1.0
 * @see LocalTime.Companion.now
 */
@JvmSynthetic
fun nowInLocalTime(timeZone: TimeZone = TimeZone.currentSystemDefault()): LocalTime =
  LocalTime.now(timeZone)

/**
 * Get current [LocalDateTime].
 *
 * Example:
 * ```Kotlin
 * nowInLocalDateTime() // 2022-10-08T00:12:00
 * ```
 * @since 1.1.0
 * @see LocalDateTime.Companion.now
 */
@JvmSynthetic
fun nowInLocalDateTime(timeZone: TimeZone = TimeZone.currentSystemDefault()): LocalDateTime =
  LocalDateTime.now(timeZone)
