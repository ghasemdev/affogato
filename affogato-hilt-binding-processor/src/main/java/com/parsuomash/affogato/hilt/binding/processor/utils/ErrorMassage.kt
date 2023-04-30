package com.parsuomash.affogato.hilt.binding.processor.utils

internal object ErrorMassage {
  const val ERROR_MASSAGE_DIMEN_TYPE_EQUALS_TO_CLASS_NAMES =
    """Dimen types must be equal to their initialized values:

    Correct:
    @Dimen(type = "sp")
    val x = 1.sp
    @Dimen(type = "dp")
    val y = 1.dp

    Wrong:
    @Dimen(type = "sp")
    val x = 1.dp
    @Dimen(type = "dp")
    val y = 10
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"""
}
