package com.parsuomash.affogato.app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.parsuomash.affogato.app.composable.WrappedColumn
import com.parsuomash.affogato.datepicker.PersianDatePicker
import com.parsuomash.affogato.datepicker.rememberPersianDatePickerState

@Composable
fun DatePickerScreen() {
  val persianDatePickerState = rememberPersianDatePickerState(
    selectedDay = 1,
    selectedMonth = 1,
    selectedYear = 1370
  )

  WrappedColumn(verticalArrangement = Arrangement.Center) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
      PersianDatePicker(
        modifier = Modifier.fillMaxWidth(),
        persianDatePickerState = persianDatePickerState
      )
    }

    Spacer(modifier = Modifier.height(50.dp))
    Text(
      text = "${persianDatePickerState.selectedYear}/" +
        "${persianDatePickerState.selectedMonth}/" +
        "${persianDatePickerState.selectedDay}"
    )
    Spacer(modifier = Modifier.height(50.dp))
  }
}
