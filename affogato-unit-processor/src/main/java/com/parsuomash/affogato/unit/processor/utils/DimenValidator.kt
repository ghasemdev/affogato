package com.parsuomash.affogato.unit.processor.utils

import com.google.devtools.ksp.processing.KSPLogger
import com.parsuomash.affogato.unit.processor.utils.ErrorMassage.ERROR_MASSAGE_DIMEN_TYPES
import com.parsuomash.affogato.unit.processor.utils.ErrorMassage.ERROR_MASSAGE_DIMEN_TYPE_EQUALS_TO_CLASS_NAMES
import com.parsuomash.affogato.unit.processor.utils.ErrorMassage.ERROR_MASSAGE_KEYS_UNIQUE
import com.parsuomash.affogato.unit.processor.utils.ErrorMassage.ERROR_MASSAGE_SAME_KEYS
import com.parsuomash.affogato.unit.processor.utils.ErrorMassage.ERROR_MASSAGE_VALID_VALUES
import com.parsuomash.affogato.unit.processor.utils.ErrorMassage.ERROR_MASSAGE_VALUES_EQUALS_SIZE
import com.parsuomash.affogato.unit.processor.utils.ErrorMassage.ERROR_MASSAGE_VALUES_SPLIT_TWO_PART

internal class DimenValidator(
  private val dimenTypes: List<String?>,
  private val dimenValues: List<List<*>?>,
  private val dimenClassNames: List<String?>,
) {
  fun validate(logger: KSPLogger) = when {
    isNoDimenTag() -> false
    !isValidDimenTypes() -> {
      logger.exception(IllegalArgumentException(ERROR_MASSAGE_DIMEN_TYPES))
      false
    }
    !isDimenTypeEqualsToClassNames() -> {
      logger.exception(
        IllegalArgumentException(ERROR_MASSAGE_DIMEN_TYPE_EQUALS_TO_CLASS_NAMES)
      )
      false
    }
    !isValuesEqualsSize() -> {
      logger.exception(IllegalArgumentException(ERROR_MASSAGE_VALUES_EQUALS_SIZE))
      false
    }
    !isValuesSplitTwoPart() -> {
      logger.exception(IllegalArgumentException(ERROR_MASSAGE_VALUES_SPLIT_TWO_PART))
      false
    }
    !isValidValues() -> {
      logger.exception(IllegalArgumentException(ERROR_MASSAGE_VALID_VALUES))
      false
    }
    !isKeysUnique() -> {
      logger.exception(IllegalArgumentException(ERROR_MASSAGE_KEYS_UNIQUE))
      false
    }
    !isSameKeys() -> {
      logger.exception(IllegalArgumentException(ERROR_MASSAGE_SAME_KEYS))
      false
    }
    else -> true
  }

  private fun isNoDimenTag() = dimenTypes.isEmpty()

  private fun isValidDimenTypes() = dimenTypes.toSet().all { it in validUnitTypes }

  private fun isDimenTypeEqualsToClassNames() =
    dimenTypes.zip(dimenClassNames) { type, className ->
      val newType = unitTypeToClassName(type)
      newType == className
    }.all { it }

  private fun isValuesEqualsSize() = dimenValues.map { it?.size }.toSet().size == 1

  private fun isValuesSplitTwoPart() = dimenValues.map { outer ->
    outer?.map { inner ->
      inner.toString().split(EQUALS_SYMBOL, COLON_SYMBOL).size == 2
    }?.all { it } ?: false
  }.all { it }

  private fun isValidValues() = dimenValues.map { outer ->
    outer?.map { inner ->
      inner.toString().split(EQUALS_SYMBOL, COLON_SYMBOL).map {
        it.trim().toIntOrNull() != null
      }.all { it }
    }?.all { it } ?: false
  }.all { it }

  private fun isKeysUnique() = dimenValues.map { outer ->
    val values = outer?.map { inner ->
      inner.toString().split(EQUALS_SYMBOL, COLON_SYMBOL).map { it.trim() }.first()
    }
    values?.toSet()?.size == values?.size
  }.all { it }

  private fun isSameKeys() = dimenValues.map { outer ->
    outer?.map { inner ->
      inner.toString().split(EQUALS_SYMBOL, COLON_SYMBOL).map { it.trim() }.first()
    } ?: listOf()
  }.run {
    val flattenList = flatten().toSet()
    map { it.containsAll(flattenList) }.all { it }
  }

  private fun unitTypeToClassName(type: String?) = when (type) {
    UNIT_DP -> PACKAGE_NAME_DP
    UNIT_SP -> PACKAGE_NAME_UNIT_TEXT
    else -> throw IllegalArgumentException(ERROR_MASSAGE_DIMEN_TYPES)
  }

  companion object {
    const val EQUALS_SYMBOL = "="
    const val COLON_SYMBOL = ":"
    const val UNIT_DP = "dp"
    const val UNIT_SP = "sp"
    const val PACKAGE_NAME_DP = "androidx.compose.ui.unit.Dp"
    const val PACKAGE_NAME_UNIT_TEXT = "androidx.compose.ui.unit.TextUnit"
    val validUnitTypes = listOf(UNIT_DP, UNIT_SP)
  }
}
