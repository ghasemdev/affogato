package com.parsuomash.affogato.app.datepicker.persian

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.parsuomash.affogato.app.datepicker.utils.persianMonthNames
import com.parsuomash.affogato.app.picker.AndroidNumberPicker

@Composable
fun PersianDatePicker2(
  modifier: Modifier = Modifier,
  persianDatePickerState: PersianDatePickerState = rememberPersianDatePickerState()
) {
  Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically
  ) {
    AndroidNumberPicker(
      modifier = Modifier.wrapContentWidth(),
      formatter = { i -> i.toString() },
      onValueChangedListener = { _, _, newVal ->
        persianDatePickerState.updateDate(persianDay = newVal)
      },
      minValue = 1,
      maxValue = persianDatePickerState.maxDay,
      selectedValue = persianDatePickerState.selectedDay,
      contentColor = Color.Blue
    )
    Spacer(
      modifier = Modifier
        .height(4.dp)
        .width(4.dp)
    )
    AndroidNumberPicker(
      modifier = Modifier.wrapContentWidth(),
      formatter = { i -> i.toString() },
      onValueChangedListener = { _, _, newVal ->
        persianDatePickerState.updateDate(persianMonth = newVal)
      },
      minValue = 1,
      maxValue = if (persianDatePickerState.maxMonth > 0) persianDatePickerState.maxMonth else 12,
      selectedValue = persianDatePickerState.selectedMonth,
      displayedValues = if (persianDatePickerState.isDisplayMonthNames) persianMonthNames else null,
      contentColor = Color.Blue
    )
    Spacer(
      modifier = Modifier
        .height(4.dp)
        .width(4.dp)
    )
    AndroidNumberPicker(
      modifier = Modifier.wrapContentWidth(),
      formatter = { i -> i.toString() },
      onValueChangedListener = { _, _, newVal ->
        persianDatePickerState.updateDate(persianYear = newVal)
      },
      minValue = persianDatePickerState.minYear,
      maxValue = persianDatePickerState.maxYear,
      selectedValue = persianDatePickerState.selectedYear,
      contentColor = Color.Blue
    )
  }

  LaunchedEffect(Unit) {
    persianDatePickerState.initDate()
  }
}

@Preview(showBackground = true)
@Composable
private fun PersianDatePicker2Preview() {
  PersianDatePicker2(modifier = Modifier.fillMaxWidth())
}
