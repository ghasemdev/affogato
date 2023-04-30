package com.parsuomash.affogato.hilt.binding.processor.internal

internal data class HiltBindingConfig(
  val packageName: String,
  val moduleName: String,
  val internalVisibility: Boolean,
)
