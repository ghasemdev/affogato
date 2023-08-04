package com.parsuomash.affogato.datepicker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.parsuomash.affogato.datepicker.picker.NumberPicker
import com.parsuomash.affogato.datepicker.picker.rememberPickerState

@Composable
fun PersianDatePicker(
  modifier: Modifier = Modifier,
  persianDatePickerState: PersianDatePickerState = rememberPersianDatePickerState()
) {
  val pickerDayState = rememberPickerState()
  val pickerMonthState = rememberPickerState()
  val pickerYearState = rememberPickerState()

  val days = remember(persianDatePickerState.maxDay) {
    val maxDay = if (persianDatePickerState.maxDay > 0) persianDatePickerState.maxDay else 31
    (1..maxDay).toList().map(Int::toString).toMutableList().apply {
      add(0, "")
      add("")
    }
  }
  val months = remember(persianDatePickerState.maxMonth) {
    val maxMonth = if (persianDatePickerState.maxMonth > 0) persianDatePickerState.maxMonth else 12
    (1..maxMonth).toList().map(Int::toString).toMutableList().apply {
      add(0, "")
      add("")
    }
  }
  val years = remember(persianDatePickerState.maxYear, persianDatePickerState.minYear) {
    (persianDatePickerState.minYear..persianDatePickerState.maxYear).toList()
      .map(Int::toString).toMutableList().apply {
        add(0, "")
        add("")
      }
  }

  val startDay = remember {
    persianDatePickerState.selectedDay - 1
  }
  val startMonth = remember {
    persianDatePickerState.selectedMonth - 1
  }
  val startYear = remember {
    persianDatePickerState.selectedYear - persianDatePickerState.minYear
  }

  Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically
  ) {
    NumberPicker(
      modifier = Modifier.weight(1f),
      state = pickerDayState,
      items = days,
      startIndex = startDay,
      textModifier = Modifier.padding(8.dp),
      textStyle = TextStyle(fontSize = 24.sp)
    )
    Spacer(
      modifier = Modifier
        .height(4.dp)
        .width(4.dp)
    )
    NumberPicker(
      modifier = Modifier.weight(1f),
      state = pickerMonthState,
      items = months,
      startIndex = startMonth,
      textModifier = Modifier.padding(8.dp),
      textStyle = TextStyle(fontSize = 24.sp)
    )
    Spacer(
      modifier = Modifier
        .height(4.dp)
        .width(4.dp)
    )
    NumberPicker(
      modifier = Modifier.weight(1f),
      state = pickerYearState,
      items = years,
      startIndex = startYear,
      textModifier = Modifier.padding(8.dp),
      textStyle = TextStyle(fontSize = 24.sp)
    )
  }

  LaunchedEffect(Unit) {
    persianDatePickerState.initDate()
  }

  LaunchedEffect(pickerDayState.item) {
    persianDatePickerState.updateDate(
      persianDay = pickerDayState.item.toIntOrNull()
    )
  }
  LaunchedEffect(pickerMonthState.item) {
    persianDatePickerState.updateDate(
      persianMonth = pickerMonthState.item.toIntOrNull()
    )
  }
  LaunchedEffect(pickerYearState.item) {
    persianDatePickerState.updateDate(
      persianYear = pickerYearState.item.toIntOrNull()
    )
  }
}

@Preview(showBackground = true)
@Composable
private fun PersianDatePickerPreview() {
  PersianDatePicker(modifier = Modifier.fillMaxWidth())
}
