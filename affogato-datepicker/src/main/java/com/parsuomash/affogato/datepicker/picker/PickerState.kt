package com.parsuomash.affogato.datepicker.picker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun rememberPickerState(): PickerState {
  return rememberSaveable(saver = PickerState.Saver) {
    PickerState()
  }
}

@Stable
class PickerState(item: String = "") {
  var item by mutableStateOf(item)

  override fun toString(): String = "PickerState(item=$item)"

  companion object {
    /**
     * The default [Saver] implementation for [PickerState].
     */
    val Saver: Saver<PickerState, *> = listSaver(
      save = { listOf(it.item) },
      restore = {
        PickerState(item = it.first())
      }
    )
  }
}
