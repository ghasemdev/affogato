package com.parsuomash.affogato.app.picker

import android.graphics.Color.parseColor
import android.widget.NumberPicker
import androidx.compose.material.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.viewinterop.AndroidView
import com.parsuomash.affogato.app.picker.utils.GlobalStyle.textColor
import com.parsuomash.affogato.app.picker.utils.GlobalStyle.textSize
import com.parsuomash.affogato.app.picker.utils.changeTextColor
import com.parsuomash.affogato.app.picker.utils.getStringColor

@Composable
fun AndroidNumberPicker(
  modifier: Modifier,
  formatter: NumberPicker.Formatter,
  onValueChangedListener: NumberPicker.OnValueChangeListener,
  minValue: Int,
  maxValue: Int,
  selectedValue: Int,
  displayedValues: Array<String>? = null,
  textStyle: TextStyle = LocalTextStyle.current,
  contentColor: Color
) {
  textSize = textStyle.fontSize.value
  textColor = parseColor(getStringColor(textStyle.color))

  AndroidView(
    modifier = modifier,
    factory = { context ->
      val numberPicker = CustomNumberPicker(context = context)
      numberPicker.setFormatter(formatter)
      numberPicker.minValue = minValue
      numberPicker.maxValue = maxValue
      numberPicker.value = selectedValue
      numberPicker.changeTextColor(contentColor.toArgb())
      numberPicker.setOnValueChangedListener(onValueChangedListener)
      if (displayedValues != null) numberPicker.displayedValues = displayedValues
      numberPicker
    },
    update = { numberPicker ->
      numberPicker.minValue = minValue
      numberPicker.maxValue = maxValue
      numberPicker.value = selectedValue
    }
  )
}
