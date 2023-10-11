@file:Suppress("MemberVisibilityCanBePrivate", "MagicNumber", "unused")

package com.parsuomash.affogato.datepicker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.parsuomash.affogato.datepicker.utils.PersianDateWrapper
import java.util.*
import saman.zamani.persiandate.PersianDate

@Composable
fun rememberPersianDatePickerState(
  isDisplayMonthNames: Boolean = true,
  date: PersianDateWrapper = PersianDateWrapper(),
  selectedYear: Int = date.value.shYear,
  selectedMonth: Int = date.value.shMonth,
  selectedDay: Int = date.value.shDay,
  minYear: Int = 1300,
  maxYear: Int = date.value.shYear,
  maxMonth: Int = 12,
  maxDay: Int = 31
): PersianDatePickerState {
  return rememberSaveable(saver = PersianDatePickerState.Saver) {
    PersianDatePickerState(
      isDisplayMonthNames = isDisplayMonthNames,
      date = date,
      selectedYear = selectedYear,
      selectedMonth = selectedMonth,
      selectedDay = selectedDay,
      minYear = minYear,
      maxYear = maxYear,
      maxMonth = maxMonth,
      maxDay = maxDay
    )
  }
}

@Stable
class PersianDatePickerState(
  isDisplayMonthNames: Boolean = true,
  date: PersianDateWrapper = PersianDateWrapper(),
  selectedYear: Int = date.value.shYear,
  selectedMonth: Int = date.value.shMonth,
  selectedDay: Int = date.value.shDay,
  minYear: Int = 1300,
  maxYear: Int = date.value.shYear,
  maxMonth: Int = 12,
  maxDay: Int = 31
) {
  var isDisplayMonthNames: Boolean by mutableStateOf(isDisplayMonthNames)
  var date: PersianDateWrapper by mutableStateOf(date)

  var minYear: Int by mutableIntStateOf(minYear)
  var maxYear: Int by mutableIntStateOf(maxYear)
  var maxMonth: Int by mutableIntStateOf(maxMonth)
  var maxDay: Int by mutableIntStateOf(maxDay)

  var selectedYear: Int by mutableIntStateOf(selectedYear)
  var selectedMonth: Int by mutableIntStateOf(selectedMonth)
  var selectedDay: Int by mutableIntStateOf(selectedDay)

  val persianYear: Int get() = date.value.shYear
  val persianMonth: Int get() = date.value.shMonth
  val persianDay: Int get() = date.value.shDay

  val gregorianDate: Date? get() = date.value.toDate()
  val gregorianYear: Int get() = date.value.grgYear
  val gregorianMonth: Int get() = date.value.grgMonth
  val gregorianDay: Int get() = date.value.grgDay

  val dayOfWeek: Int get() = date.value.dayOfWeek()
  val persianMonthName: String? get() = date.value.monthName
  val persianDayOfWeekName: String? get() = date.value.dayName()

  val timestamp: Long get() = date.value.time

  fun updateDate(timestamp: Long) {
    date = PersianDateWrapper(value = PersianDate(timestamp))
  }

  fun updateDate(date: Date) {
    this.date = PersianDateWrapper(value = PersianDate(date))
  }

  fun updateDate(persianYear: Int? = null, persianMonth: Int? = null, persianDay: Int? = null) {
    if (persianYear != null) selectedYear = persianYear
    if (persianMonth != null) selectedMonth = persianMonth
    if (persianDay != null) selectedDay = persianDay

    val isLeapYear = date.value.isLeap(selectedYear)

    when {
      selectedMonth < 7 -> {
        maxDay = 31
      }

      selectedMonth < 12 -> {
        if (selectedDay == 31) {
          selectedDay = 30
        }
        maxDay = 30
      }

      selectedMonth == 12 -> {
        if (isLeapYear) {
          if (selectedDay == 31) {
            selectedDay = 30
          }
          maxDay = 30
        } else {
          if (selectedDay > 29) {
            selectedDay = 29
          }
          maxDay = 29
        }
      }
    }

    updateDate(
      persianDay = selectedDay,
      persianMonth = selectedMonth,
      persianYear = selectedYear
    )
  }

  private fun updateDate(persianYear: Int, persianMonth: Int, persianDay: Int) {
    date.value.apply {
      shYear = persianYear
      shMonth = persianMonth
      shDay = persianDay
    }
  }

  fun resetDate(onDateChanged: ((year: Int, month: Int, day: Int) -> Unit)? = null) {
    date = PersianDateWrapper()

    selectedYear = date.value.shYear
    selectedMonth = date.value.shMonth
    selectedDay = date.value.shDay

    if (onDateChanged != null) {
      onDateChanged(
        date.value.shYear,
        date.value.shMonth,
        date.value.shDay
      )
    }
  }

  fun initDate() {
    if (minYear > selectedYear) {
      minYear = selectedYear
    }
    if (maxYear < selectedYear) {
      maxYear = selectedYear
    }

    if (selectedYear > maxYear) {
      selectedYear = maxYear
    }
    if (selectedYear < minYear) {
      selectedYear = minYear
    }

    if (selectedMonth in 7..11 && selectedDay == 31) {
      selectedDay = 30
    } else {
      val isLeapYear = date.value.isLeap(selectedYear)
      if (isLeapYear && selectedDay == 31) {
        selectedDay = 30
      } else if (selectedDay > 29) {
        selectedDay = 29
      }
    }
  }

  override fun toString(): String = "$selectedYear/$selectedMonth/$selectedDay"

  companion object {
    /**
     * The default [Saver] implementation for [PersianDatePickerState].
     */
    val Saver: Saver<PersianDatePickerState, *> = listSaver(
      save = {
        listOf(
          it.isDisplayMonthNames,
          it.date.value.time,
          it.selectedYear,
          it.selectedMonth,
          it.selectedDay,
          it.minYear,
          it.maxYear,
          it.maxMonth,
          it.maxDay
        )
      },
      restore = {
        PersianDatePickerState(
          isDisplayMonthNames = it[0] as Boolean,
          date = PersianDateWrapper(value = PersianDate(it[1] as Long)),
          selectedYear = it[2] as Int,
          selectedMonth = it[3] as Int,
          selectedDay = it[4] as Int,
          minYear = it[5] as Int,
          maxYear = it[6] as Int,
          maxMonth = it[7] as Int,
          maxDay = it[8] as Int
        )
      }
    )
  }
}
