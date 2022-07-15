package com.parsuomash.affogato.unit.processor.utils

internal object ErrorMassage {
    const val ERROR_MASSAGE_DIMEN_TYPES = """Use valid Dimen types `@Dimen(type "sp|dp")`
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"""

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

    const val ERROR_MASSAGE_VALUES_EQUALS_SIZE =
        """Dimen values must be of equals size:

    Correct:
    @Dimen(type = "sp", values = ["320=1", "480=2", "600=3"])
    val x = 1.sp
    @Dimen(type = "dp", values = ["320=10", "480=12", "600=14"])
    val y = 10.dp

    Wrong:
    @Dimen(type = "sp", values = ["320=1", "480=2", "600=3", "720=4"])
    val x = 1.sp
    @Dimen(type = "dp", values = ["320=10", "480=12", "600=14"])
    val y = 10.dp
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"""

    const val ERROR_MASSAGE_VALUES_SPLIT_TWO_PART =
        """Dimen values must have two parts and be in the following format:
    "SCREEN_WIDTH:VALUE" or "SCREEN_WIDTH=VALUE"

    Correct:
    @Dimen(type = "sp", values = ["320:1", "480:2", "600:3"])
    val x = 1.sp

    Wrong:
    @Dimen(type = "sp", values = ["320;1", "2", "600"])
    val x = 1.sp
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"""

    const val ERROR_MASSAGE_VALID_VALUES =
        """Dimen values must be numerical on both sides of the delimiter:
    "SCREEN_WIDTH(Int):VALUE(Int)" or "SCREEN_WIDTH(Int)=VALUE(Int)"

    Correct:
    @Dimen(type = "sp", values = ["320=1", "480=2", "600=3"])
    val x = 1.sp

    Wrong:
    @Dimen(type = "sp", values = ["sw320=1", "480=2.0", "600.0=3"])
    val x = 1.sp
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"""

    const val ERROR_MASSAGE_KEYS_UNIQUE =
        """Dimen values should use only unique keys on the left side of the delimiter:

    Correct:
    @Dimen(type = "sp", values = ["320=1", "480=2", "600=3"])
    val x = 1.sp

    Wrong:
    @Dimen(type = "sp", values = ["320=1", "320=2", "600=3"])
    val x = 1.sp
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"""

    const val ERROR_MASSAGE_SAME_KEYS =
        """All unit values key must be the same:

    Correct:
    @Dimen(type = "sp", values = ["320=1", "480=2", "600=3"])
    val x = 1.sp
    @Dimen(type = "sp", values = ["320=10", "480=12", "600=14"])
    val x = 10.sp

    Wrong:
    @Dimen(type = "sp", values = ["320=1", "480=2", "600=3"])
    val x = 1.sp
    @Dimen(type = "sp", values = ["480=10", "600=12", "720=14"])
    val x = 10.sp
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"""
}
