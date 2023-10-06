@file:Suppress("unused")

package com.parsuomash.affogato.pdfviewer.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import com.parsuomash.affogato.pdfviewer.internal.PdfRenderer
import java.io.File

abstract class PdfReaderState(
  val resource: ResourceType,
  isZoomEnable: Boolean = false,
  val isAccessibleEnable: Boolean = false,
) {
  internal var mError by mutableStateOf<Throwable?>(null)
  val error: Throwable?
    get() = mError

  private var mIsZoomEnable by mutableStateOf(isZoomEnable)
  val isZoomEnable: Boolean
    get() = mIsZoomEnable

  fun changeZoomState(enable: Boolean) {
    mIsZoomEnable = enable
  }

  internal var mScale by mutableFloatStateOf(1f)
  val scale: Float
    get() = mScale

  internal var offset by mutableStateOf(Offset(0f, 0f))

  internal var mFile by mutableStateOf<File?>(null)
  val file: File?
    get() = mFile

  internal var pdfRender by mutableStateOf<PdfRenderer?>(null)

  internal var mLoadPercent by mutableIntStateOf(0)
  val loadPercent: Int
    get() = mLoadPercent

  val pdfPageCount: Int
    get() = pdfRender?.pageCount ?: 0

  abstract val currentPage: Int

  val isLoaded
    get() = mFile != null

  abstract val isScrolling: Boolean

  fun close() {
    pdfRender?.close()
    pdfRender = null
  }
}
