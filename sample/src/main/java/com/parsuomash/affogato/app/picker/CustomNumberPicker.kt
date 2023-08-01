package com.parsuomash.affogato.app.picker

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.NumberPicker
import com.parsuomash.affogato.app.picker.utils.GlobalStyle

internal class CustomNumberPicker : NumberPicker {
  constructor(context: Context?) : super(context!!)

  constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs)

  constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
    context!!,
    attrs,
    defStyleAttr
  )

  init {
    descendantFocusability = FOCUS_BLOCK_DESCENDANTS
  }

  override fun addView(child: View) {
    super.addView(child)
    updateView(child)
  }

  override fun addView(
    child: View, index: Int,
    params: ViewGroup.LayoutParams
  ) {
    super.addView(child, index, params)
    updateView(child)
  }

  override fun addView(child: View, params: ViewGroup.LayoutParams) {
    super.addView(child, params)
    updateView(child)
  }

  private fun updateView(view: View) {
    if (view is EditText) {
      if (GlobalStyle.typeface != null) view.typeface = GlobalStyle.typeface
      if (GlobalStyle.textSize != null) view.textSize = GlobalStyle.textSize!!
      if (GlobalStyle.textColor != null) view.setTextColor(GlobalStyle.textColor!!)
    }
  }
}
