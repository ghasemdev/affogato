package com.parsuomash.affogato.core.ktx.time

import com.parsuomash.affogato.core.ktx.datetime.asCalendar
import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.now
import java.util.*
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
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
fun nowInDate(): Date = nowInMilliseconds().asDate

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
fun nowInCalendar(): Calendar = nowInMilliseconds().asCalendar

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
fun nowInLocalDate(timeZone: TimeZone = TimeZone.currentSystemDefault()): LocalDate =
  LocalDate.now(timeZone)

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
fun nowInLocalDateTime(timeZone: TimeZone = TimeZone.currentSystemDefault()): LocalDateTime =
  LocalDateTime.now(timeZone)
