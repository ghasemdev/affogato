package com.parsuomash.affogato.core.ktx.datetime

import com.parsuomash.affogato.core.ktx.safeThread
import java.text.SimpleDateFormat

@get:JvmSynthetic
internal val simpleDateFormat: SimpleDateFormat by safeThread { SimpleDateFormat() }
