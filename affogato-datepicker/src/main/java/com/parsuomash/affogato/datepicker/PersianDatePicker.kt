package com.parsuomash.affogato.datepicker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.parsuomash.affogato.datepicker.picker.ListItemPicker
import com.parsuomash.affogato.datepicker.utils.persianMonthNames

@Composable
fun PersianDatePicker(
  modifier: Modifier = Modifier,
  persianDatePickerState: PersianDatePickerState = rememberPersianDatePickerState(),
  textStyle: TextStyle = MaterialTheme.typography.body1,
  dividerColor: Color = MaterialTheme.colors.primary
) {
  val days = remember(persianDatePickerState.maxDay) {
    (1..persianDatePickerState.maxDay).toList()
  }
  val months = remember(persianDatePickerState.maxMonth) {
    (1..persianDatePickerState.maxMonth).toList()
  }
  val years = remember(persianDatePickerState.maxYear, persianDatePickerState.minYear) {
    (persianDatePickerState.minYear..persianDatePickerState.maxYear).toList()
  }

  Column(horizontalAlignment = Alignment.CenterHorizontally) {
    Row(modifier = modifier) {
      ListItemPicker(
        modifier = Modifier
          .weight(1f)
          .padding(horizontal = 1.dp),
        list = days,
        value = persianDatePickerState.selectedDay,
        textStyle = textStyle,
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
        value = persianDatePickerState.selectedMonth,
        textStyle = textStyle,
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
        value = persianDatePickerState.selectedYear,
        textStyle = textStyle,
        dividersColor = dividerColor,
        onValueChange = {
          persianDatePickerState.updateDate(persianYear = it)
        }
      )
    }
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
