@file:JvmName("_SimpleDateFormat")

package com.parsuomash.affogato.core.ktx.datetime

import java.text.SimpleDateFormat

@get:JvmSynthetic
internal val simpleDateFormat: SimpleDateFormat by lazy { SimpleDateFormat() }
