package com.parsuomash.affogato.hilt.binding.processor.utils

import com.google.devtools.ksp.processing.KSPLogger

internal class DimenValidator(
  private val dimenTypes: List<String?>,
  private val dimenValues: List<List<*>?>,
  private val dimenClassNames: List<String?>,
) {
  fun validate(logger: KSPLogger) = when {
    else -> true
  }

  companion object {
    const val EQUALS_SYMBOL = "="
    const val COLON_SYMBOL = ":"
  }
}
