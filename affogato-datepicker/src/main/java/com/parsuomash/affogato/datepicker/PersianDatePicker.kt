package com.parsuomash.affogato.datepicker

import androidx.annotation.FloatRange
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.parsuomash.affogato.datepicker.picker.ListItemPicker
import com.parsuomash.affogato.datepicker.utils.persianMonthNames
import kotlinx.collections.immutable.toPersistentList

@Composable
fun PersianDatePicker(
  modifier: Modifier = Modifier,
  persianDatePickerState: PersianDatePickerState = rememberPersianDatePickerState(),
  textStyle: TextStyle = MaterialTheme.typography.body1,
  @FloatRange(from = 1.0, to = 2.0) selectedTextScale: Float = 1f,
  dividerColor: Color = MaterialTheme.colors.primary
) {
  val days = remember(persianDatePickerState.maxDay) {
    (1..persianDatePickerState.maxDay).toPersistentList()
  }
  val months = remember(persianDatePickerState.maxMonth) {
    (1..persianDatePickerState.maxMonth).toPersistentList()
  }
  val years = remember(persianDatePickerState.maxYear, persianDatePickerState.minYear) {
    (persianDatePickerState.minYear..persianDatePickerState.maxYear).toPersistentList()
  }

  Row(modifier = modifier, horizontalArrangement = Arrangement.Center) {
    ListItemPicker(
      modifier = Modifier
        .weight(1f)
        .padding(horizontal = 1.dp),
      list = days,
      provideValue = { persianDatePickerState.selectedDay },
      textStyle = textStyle,
      selectedTextScale = selectedTextScale,
      dividersColor = dividerColor,
      onValueChange = {
        persianDatePickerState.updateDate(persianDay = it)
      }
    )

    ListItemPicker(
      modifier = Modifier
        .weight(1f)
        .padding(horizontal = 1.dp),
      list = months,
      provideValue = { persianDatePickerState.selectedMonth },
      textStyle = textStyle,
      selectedTextScale = selectedTextScale,
      dividersColor = dividerColor,
      label = {
        if (persianDatePickerState.isDisplayMonthNames) {
          persianMonthNames.getOrElse(it - 1) { "" }
        } else {
          it.toString()
        }
      },
      onValueChange = {
        persianDatePickerState.updateDate(persianMonth = it)
      }
    )

    ListItemPicker(
      modifier = Modifier
        .weight(1f)
        .padding(horizontal = 1.dp),
      list = years,
      provideValue = { persianDatePickerState.selectedYear },
      textStyle = textStyle,
      selectedTextScale = selectedTextScale,
      dividersColor = dividerColor,
      onValueChange = {
        persianDatePickerState.updateDate(persianYear = it)
      }
    )
  }

  LaunchedEffect(Unit) {
    persianDatePickerState.initDate()
  }
}

@Preview(showBackground = true)
@Composable
private fun PersianDatePickerPreview() {
  PersianDatePicker(modifier = Modifier.fillMaxWidth())
}
