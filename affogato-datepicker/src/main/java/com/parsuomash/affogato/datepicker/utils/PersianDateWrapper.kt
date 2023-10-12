package com.parsuomash.affogato.datepicker.utils

import androidx.compose.runtime.Immutable
import saman.zamani.persiandate.PersianDate

@Immutable
data class PersianDateWrapper(val value: PersianDate = PersianDate())
