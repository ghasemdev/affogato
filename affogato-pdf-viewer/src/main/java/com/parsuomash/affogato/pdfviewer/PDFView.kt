package com.parsuomash.affogato.pdfviewer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.util.FitPolicy
import com.parsuomash.affogato.pdfviewer.state.ResourceType
import com.parsuomash.affogato.pdfviewer.state.VerticalPdfReaderState
import com.parsuomash.affogato.pdfviewer.zoomable.ZoomableDefaults
import com.parsuomash.affogato.pdfviewer.zoomable.ZoomableState
import com.parsuomash.affogato.pdfviewer.zoomable.rememberZoomableState

@Composable
fun PDFView(
  modifier: Modifier = Modifier,
  state: VerticalPdfReaderState,
  zoomableState: ZoomableState = rememberZoomableState(
    minScale = ZoomableDefaults.DefaultScale
  )
) {
  val coroutineScope = rememberCoroutineScope()
  val context = LocalContext.current

  AndroidView(
    modifier = modifier,
    factory = {
      PDFView(context, null).apply {
        fromUri((state.resource as ResourceType.Local).uri)
          .pageFitPolicy(FitPolicy.WIDTH)
          .load()
      }
    },
    update = { pdfView ->
    }
  )
}
