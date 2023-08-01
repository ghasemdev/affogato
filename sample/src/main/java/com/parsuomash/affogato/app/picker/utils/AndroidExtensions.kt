package com.parsuomash.affogato.app.picker.utils

import android.annotation.SuppressLint
import android.graphics.Paint
import android.os.Build
import android.view.View
import android.widget.EditText
import android.widget.NumberPicker
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import java.lang.reflect.Field

internal fun getStringColor(color: Color): String {
  return color.toArgb().hexToString()
}

private fun Int.hexToString() = String.format("#%06X", 0xFFFFFF and this)

@SuppressLint("DiscouragedPrivateApi")
internal fun NumberPicker.changeTextColor(color: Int) {
  if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
    val count: Int = childCount
    for (i in 0 until count) {
      val child: View = getChildAt(i)
      if (child is EditText) {
        try {
          child.setTextColor(color)
          invalidate()
          val selectorWheelPaintField: Field =
            this.javaClass.getDeclaredField("mSelectorWheelPaint")
          var accessible: Boolean = selectorWheelPaintField.isAccessible
          selectorWheelPaintField.isAccessible = true
          (selectorWheelPaintField.get(this) as Paint).color = color
          selectorWheelPaintField.isAccessible = accessible
          invalidate()
          val selectionDividerField: Field = this.javaClass.getDeclaredField("mSelectionDivider")
          accessible = selectionDividerField.isAccessible
          selectionDividerField.isAccessible = true
          selectionDividerField.set(this, null)
          selectionDividerField.isAccessible = accessible
          invalidate()
        } catch (ignore: Exception) {
        }
      }
    }
  } else {
    textColor = color
  }
}
