package com.parsuomash.affogato.pager.indicator.saver

import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.ui.unit.IntSize

internal val IntSize.Companion.saver: Saver<IntSize, *>
  get() = listSaver(
    save = {
      listOf(it.width, it.height)
    }, restore = {
      IntSize(
        width = it[0],
        height = it[1]
      )
    }
  )
